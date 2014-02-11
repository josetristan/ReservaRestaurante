package com.jtristan.reservarestaurante.thread;

import java.io.IOException;

import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.Usuarioendpoint;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario;

	
public class EndPointUsuarioPorIDTask extends AsyncTask<Long, Integer, Usuario> {
	
	private final static String TAG = EndPointUsuarioPorIDTask.class.getSimpleName();	

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(Usuario usuario);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointUsuarioPorIDTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	protected Usuario doInBackground(Long... ids) {
		
		Usuario usuario=null;

		Usuarioendpoint.Builder endpointBuilder = new Usuarioendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});


		Usuarioendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();

		try {
			
			usuario = endpoint.getUsuario(ids[0]).execute();			
			

		} catch (IOException e) {										
				Log.e(TAG, e.getMessage());				
		}
		return usuario;
	}

	@Override
	protected void onPostExecute(Usuario result) {
		super.onPostExecute(result);
		asyncTaskListener.onFinish(result);
	}
}


