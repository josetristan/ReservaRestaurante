package com.jtristan.reservarestaurante.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.Ofertaendpoint;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.model.CollectionResponseOferta;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.model.Oferta;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.Restauranteendpoint;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;


	
public class EndPointOfertaTask extends AsyncTask<Void, Integer, List<Oferta>> {
	
	private final static String TAG = EndPointOfertaTask.class.getSimpleName();	

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(List<Oferta> oferta);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointOfertaTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	protected List<Oferta> doInBackground(Void... params) {
		
		List<Oferta> ofertas = new ArrayList<Oferta>();

		Ofertaendpoint.Builder endpointBuilder = new Ofertaendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});


		Ofertaendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();
		
		try {
						
			CollectionResponseOferta ofertaCollection = endpoint.listOferta().execute();
			ofertas = ofertaCollection.getItems();
			
						
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());            
		}
		return ofertas;
	}

	@Override
	protected void onPostExecute(List<Oferta> resultados) {
		super.onPostExecute(resultados);
		asyncTaskListener.onFinish(resultados);
	}

	
	
}


