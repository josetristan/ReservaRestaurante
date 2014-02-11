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
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.Restauranteendpoint;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.CollectionResponseRestaurante;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;

	
public class EndPointRestauranteTask extends AsyncTask<Long, Integer, List<Restaurante>> {
	
	private final static String TAG = EndPointRestauranteTask.class.getSimpleName();	

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(List<Restaurante> restaurantes);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointRestauranteTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	protected List<Restaurante> doInBackground(Long... ids) {

		List<Restaurante> restaurantes=null;

		Restauranteendpoint.Builder endpointBuilder = new Restauranteendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});

		
			Restauranteendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();		

		try {
			if (ids.length==0){
				CollectionResponseRestaurante collectionRestaurante = endpoint.listRestaurante().execute();				restaurantes = collectionRestaurante.getItems();
			}else{
				Restaurante restaurante = endpoint.getRestaurante(ids[0]).execute();
				restaurantes = new ArrayList<Restaurante>();
				restaurantes.add(restaurante);
			}


		} catch (IOException e) {
			Log.e(TAG, e.getMessage());            
		}
		return restaurantes;
	}

	@Override
	protected void onPostExecute(List<Restaurante> result) {
		super.onPostExecute(result);
		asyncTaskListener.onFinish(result);
	}
}


