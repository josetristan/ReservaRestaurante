package com.jtristan.reservarestaurante.ui;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.Ids;
import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.adapter.ReservaAdapter;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.Reservaendpoint;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.CollectionResponseReserva;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Reserva;

public class ReservaActivity extends Activity{
				

	private final static String TAG = ReservaActivity.class.getSimpleName();
	private final static String NOMBRE_FICHERO_PREFERENCIAS = "Preferencias";
	private static final String PREF_NOMBRE_CUENTA = "nombreCuenta";
	
	private SharedPreferences preferencias;
	private String nombreCuenta;
	private GoogleAccountCredential credenciales;
	
	static ListView listView;
	//List<Reserva> restaurantes = new ArrayList<Reserva>();
	ReservaAdapter adaptador;
	Context contexto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reservas);

		listView = (ListView) this.findViewById(R.id.listView);
		
		contexto = this;
	
		obtenerCredenciales();
		
		new EndPointReservaTask().execute();
	}
	
	private void obtenerCredenciales() {
		credenciales = GoogleAccountCredential.usingAudience(this, "server:client_id:"+Ids.WEB_CLIENT_ID);		
		preferencias = this.getSharedPreferences(NOMBRE_FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);
		if (preferencias.getString(PREF_NOMBRE_CUENTA, "")!=""){
			credenciales.setSelectedAccountName(preferencias.getString(PREF_NOMBRE_CUENTA, ""));
		}		
	}

	
	
	public class EndPointReservaTask extends AsyncTask<Void, Integer, List<Reserva>> {
					
		public EndPointReservaTask(){
			
		}

		protected List<Reserva> doInBackground(Void... params) {
			
			List<Reserva> resultado = null;		
			
			Reservaendpoint.Builder endpointBuilderReserva = new Reservaendpoint.Builder(
					AndroidHttp.newCompatibleTransport(),
					new JacksonFactory(),
					credenciales);
					
			Reservaendpoint endpointReserva = CloudEndpointUtils.updateBuilder(
					endpointBuilderReserva).build();
					
			try {
							
				CollectionResponseReserva collectionReserva =  endpointReserva.listReserva().execute();
				resultado = collectionReserva.getItems();
				
				

			} catch (IOException e) {
				Log.e(TAG, e.getMessage());            
			}
			return resultado;
		}

		@Override
		protected void onPostExecute(List<Reserva> resultado) {
			super.onPostExecute(resultado);
			
			ReservaAdapter adaptador = new ReservaAdapter(contexto, R.layout.reserva_adapter,
					resultado);
			listView.setAdapter(adaptador);
		}
		
		
	}

}
