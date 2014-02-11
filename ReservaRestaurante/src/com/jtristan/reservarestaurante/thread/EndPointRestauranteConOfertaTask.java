package com.jtristan.reservarestaurante.thread;

import java.io.IOException;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.Ofertaendpoint;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.model.Restaurante;

	
public class EndPointRestauranteConOfertaTask extends AsyncTask<String, Integer, Void> {
	
	private final static String TAG = EndPointRestauranteConOfertaTask.class.getSimpleName();
	private Restaurante restaurante;

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(Restaurante restaurante);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointRestauranteConOfertaTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	@Override
	protected Void doInBackground(String... idsOfertas) {
		
		Ofertaendpoint.Builder endpointBuilder = new Ofertaendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});


		Ofertaendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();

		try {

			restaurante = endpoint.getRestaurante(idsOfertas[0]).execute();
			

		} catch (IOException e) {
			Log.e(TAG, e.getMessage());            
		}		
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {	
		super.onPostExecute(result);
		asyncTaskListener.onFinish(restaurante);
	}

				
}


