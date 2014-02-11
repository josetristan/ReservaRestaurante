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
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.Usuarioendpoint;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.CollectionResponseUsuario;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario;

	
public class EndPointUsuarioTask extends AsyncTask<String, Integer, List<Usuario>> {
	
	private final static String TAG = EndPointUsuarioTask.class.getSimpleName();	

	public interface AsyncTaskListener{ void onInit(); void onProgressUpdate(); void onCancel(); void onFinish(List<Usuario> usuarios);}
	private AsyncTaskListener asyncTaskListener;
	
	public EndPointUsuarioTask(AsyncTaskListener asyncTaskListener){
		this.asyncTaskListener = asyncTaskListener;
	}

	protected List<Usuario> doInBackground(String... mails) {
		
		List<Usuario> usuarios=null;

		Usuarioendpoint.Builder endpointBuilder = new Usuarioendpoint.Builder(
				AndroidHttp.newCompatibleTransport(),
				new JacksonFactory(),
				new HttpRequestInitializer() {
					public void initialize(HttpRequest httpRequest) { }
				});


		Usuarioendpoint endpoint = CloudEndpointUtils.updateBuilder(
				endpointBuilder).build();

		try {

			if (mails.length>0)
				endpoint.listUsuario().setMail(mails[0]);
				
			CollectionResponseUsuario collectionUsuarios = endpoint.listUsuario().execute();			
			usuarios = collectionUsuarios.getItems();


		} catch (IOException e) {
			Log.e(TAG, e.getMessage());            
		}
		return usuarios;
	}

	@Override
	protected void onPostExecute(List<Usuario> result) {
		super.onPostExecute(result);
		asyncTaskListener.onFinish(result);
	}
}


