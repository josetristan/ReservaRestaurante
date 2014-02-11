package com.jtristan.reservarestaurante.thread;

import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.Restauranteendpoint;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.CartaCollection;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Carta;


	
public class EndPointCartaTask extends AsyncTask<Long, Integer, List<Carta>> {
	
	private final static String TAG = EndPointOfertaTask.class.getSimpleName();
	

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(List<Carta> carta);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointCartaTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	protected List<Carta> doInBackground(Long... ids) {

		List<Carta> carta=null;
		
		Restauranteendpoint.Builder endpointBuilder = new Restauranteendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});


		Restauranteendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();

		try {			
			CartaCollection cartaCollection = endpoint.getCarta(ids[0]).execute();
			carta = cartaCollection.getItems();
						

		} catch (Exception e) {
			Log.e(TAG, e.getMessage());            
		}
		return carta;
	}

	@Override
	protected void onPostExecute(List<Carta> result) {
		super.onPostExecute(result);
		asyncTaskListener.onFinish(result);
	}

	
	
}


