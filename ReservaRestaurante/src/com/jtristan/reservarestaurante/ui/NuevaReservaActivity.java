package com.jtristan.reservarestaurante.ui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.jtristan.reservarestaurante.CloudEndpointUtils;
import com.jtristan.reservarestaurante.Ids;
import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.Reservaendpoint;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Reserva;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.User;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario;
import com.jtristan.reservarestaurante.thread.EndPointRestauranteTask;
import com.jtristan.reservarestaurante.thread.EndPointUsuarioTask;


public class NuevaReservaActivity extends Activity implements  OnClickListener, OnItemSelectedListener{
		
	private final static String TAG = NuevaReservaActivity.class.getSimpleName();
	private final static int RECOGER_SOLICITUD_CUENTA = 1;	
	private static final String PREF_NOMBRE_CUENTA = "nombreCuenta";	
	private final static String NOMBRE_FICHERO_PREFERENCIAS = "Preferencias";
	
	private SharedPreferences preferencias;
	private String nombreCuenta;
	private GoogleAccountCredential credenciales;
	
	
	private TextView tvUsuario;
	private static Spinner spRestaurante;
	private EditText etFecha;
	private EditText etNumeroComensales;
	private static Spinner spComensal1;
	private static Spinner spComensal2;
	private Button btAceptar;
	private static String[] restaurantesArray = null;
	private static String[] comensalesArray = null;
	private static List<Restaurante> restaurantes;
	private static List<Usuario> usuarios;
	private Integer restauranteSeleccionado=null;
	private Integer comensal1Seleccionado=null;
	private Integer comensal2Seleccionado=null;
	private Activity contexto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reserva);
		
		contexto = this;
				
		tvUsuario = (TextView)this.findViewById(R.id.tvUsuario);
		spRestaurante = (Spinner)this.findViewById(R.id.spRestaurante);
		etFecha = (EditText)this.findViewById(R.id.etFecha);
		etNumeroComensales = (EditText)this.findViewById(R.id.etNumeroComensales);
		spComensal1 = (Spinner)this.findViewById(R.id.spComensal1);
		spComensal2 = (Spinner)this.findViewById(R.id.spComensal2);
		btAceptar = (Button)this.findViewById(R.id.btAceptar);
		
	
		btAceptar.setOnClickListener(this);
		spRestaurante.setOnItemSelectedListener(this);
		spComensal1.setOnItemSelectedListener(this);
		spComensal2.setOnItemSelectedListener(this);
		
		obtenerCredenciales();
				
		EndPointRestauranteTask restauranteTask = new EndPointRestauranteTask(new EndPointRestauranteTask.AsyncTaskListener() {
			
			@Override
			public void onProgressUpdate() {}
			
			@Override
			public void onInit() {}
			
			@Override
			public void onFinish(List<com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante> restaurantes) {
				
				if (restaurantes!=null){
					NuevaReservaActivity.restaurantes = restaurantes;
					int i=0;
					NuevaReservaActivity.restaurantesArray = new String[restaurantes.size()];
					for (Restaurante restaurante: restaurantes){
						NuevaReservaActivity.restaurantesArray[i] = restaurante.getNombre();
						i++;
					}
				}	
				spRestaurante.setAdapter(getAdaptador(restaurantesArray));
			}
			
			@Override
			public void onCancel() {}
		}); 
		
		restauranteTask.execute();
		
		
		EndPointUsuarioTask comensalTask = new EndPointUsuarioTask(new EndPointUsuarioTask.AsyncTaskListener() {
			
			@Override
			public void onProgressUpdate() {}
			
			@Override
			public void onInit() {}
			
			@Override
			public void onFinish(List<Usuario> usuarios) {
				NuevaReservaActivity.usuarios = usuarios;
				
				int i=0;
				NuevaReservaActivity.comensalesArray = new String[usuarios.size()];
				for (Usuario usuario: usuarios){
					NuevaReservaActivity.comensalesArray[i] = usuario.getNombre() + " " + usuario.getApellidos();
					i++;
				}		
								
				spComensal1.setAdapter(getAdaptador(comensalesArray));
				spComensal2.setAdapter(getAdaptador(comensalesArray));
			}
			
			@Override
			public void onCancel() {}
		});
		
		comensalTask.execute();
														    	    
																		
	}

	private void obtenerCredenciales() {
		credenciales = GoogleAccountCredential.usingAudience(this, "server:client_id:"+Ids.WEB_CLIENT_ID);	
		preferencias = this.getSharedPreferences(NOMBRE_FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);
		if (preferencias.getString(PREF_NOMBRE_CUENTA, "")!=""){
			//seleccionarCuenta();
		//}else{
			credenciales.setSelectedAccountName(preferencias.getString(PREF_NOMBRE_CUENTA, ""));
			nombreCuenta = preferencias.getString(PREF_NOMBRE_CUENTA, "");
		}else{
			Toast.makeText(this, "Debe loguearse primero", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, LoginActivity.class);
			this.startActivity(intent);
		}
		tvUsuario.setText(nombreCuenta);
		
	}

	/*@Override protected void onActivityResult(int  requestCode,  int  resultCode,  Intent  data)  {          
		super.onActivityResult(requestCode,  resultCode,  data);          
		
		switch  (requestCode)  {          	
			case  RECOGER_SOLICITUD_CUENTA:                  
				if  (data  !=  null  &&  data.getExtras()  !=  null)  {                          
					Bundle  bundle  =  data.getExtras();                          
					String  nombreCuenta  =  bundle.getString(AccountManager.KEY_ACCOUNT_NAME); 					
					if  (nombreCuenta !=  null)  {                                  
						setNombreCuenta(nombreCuenta);
					}                  
				}                  
				break;          
			}  
		}   
	
	
	 private void seleccionarCuenta() {
		 startActivityForResult(credenciales.newChooseAccountIntent(), RECOGER_SOLICITUD_CUENTA);
	 }

	private void setNombreCuenta(String nombreCuenta) {
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putString(PREF_NOMBRE_CUENTA, nombreCuenta);
		editor.commit();
		credenciales.setSelectedAccountName(nombreCuenta);
		this.nombreCuenta = nombreCuenta;
	}*/

	private ArrayAdapter<CharSequence> getAdaptador(CharSequence[] arary) {
		
		ArrayAdapter<CharSequence> adaptador = new ArrayAdapter<CharSequence>(this,
		         android.R.layout.simple_spinner_item, arary);							
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		return adaptador;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btAceptar:
			pasarAEntidad();
			break;		
		}

		
	}

	private void pasarAEntidad() {
					
		List<Usuario> comensalesReserva = new ArrayList<Usuario>(); 
		Reserva reserva = new Reserva();
		reserva.setNumeroPersonas(Integer.parseInt(etNumeroComensales.getText().toString()));	
						
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date fecha=null;
		try {
			fecha = sdf.parse(etFecha.getText().toString());
		} catch (ParseException e) {
			Log.e(TAG, e.getMessage());
		}
		
		com.google.api.client.util.DateTime datetime = new com.google.api.client.util.DateTime(fecha);
		
		reserva.setHoraReserva(datetime);
		reserva.setRestaurante(pasarAEntidadRestauranteReserva(restaurantes.get(restauranteSeleccionado)));
		if (comensal1Seleccionado!=null){
			comensalesReserva.add(usuarios.get(comensal1Seleccionado));			
		}
		if (comensal2Seleccionado!=null){			
			comensalesReserva.add(usuarios.get(comensal2Seleccionado));
		}
		if (comensalesReserva.size()>0){
			reserva.setComensales(pasarAEntidadUsuarioReserva(comensalesReserva));
		}
			
		new EndPointNuevaReservaTask().execute(reserva);
		
		
	}

	private List<com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario> pasarAEntidadUsuarioReserva(
			List<Usuario> comensalesReserva) {
				
		List<com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario> usuariosReserva = new ArrayList<com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario>();
		com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario usuarioReserva;
		
		for (Usuario comensal: comensalesReserva){
			usuarioReserva = new com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario();
			usuarioReserva.setId(comensal.getId());
			usuarioReserva.setNombre(comensal.getNombre());
			usuarioReserva.setApellidos(comensal.getApellidos());
			usuarioReserva.setCuentaGoogle(pasarAEntidadCuentaGoogleReserva(comensal.getCuentaGoogle()));
			usuariosReserva.add(usuarioReserva);
		}
		
				
		return usuariosReserva;
	}

	private User pasarAEntidadCuentaGoogleReserva(
			com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.User cuentaGoogle) {
		
		com.jtristan.reservarestaurante.entidad.reservaendpoint.model.User cuentaGoogleReserva = new com.jtristan.reservarestaurante.entidad.reservaendpoint.model.User();
		
		if (cuentaGoogle!=null)	{
			cuentaGoogleReserva.setEmail(cuentaGoogle.getEmail());		
			cuentaGoogleReserva.setAuthDomain(cuentaGoogle.getAuthDomain());		
			cuentaGoogleReserva.setNickname(cuentaGoogle.getNickname());		
			cuentaGoogleReserva.setUserId(cuentaGoogle.getUserId());
		}
						
		return cuentaGoogleReserva;
	}

	private com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Restaurante pasarAEntidadRestauranteReserva(
			Restaurante restaurante) {
		
		com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Restaurante restauranteReserva = new com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Restaurante();
		restauranteReserva.setId(restaurante.getId());		
											
		return restauranteReserva;
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int posicion, long id) {
		
		switch (arg0.getId()) {
		case R.id.spRestaurante:
			restauranteSeleccionado = posicion;
			break;
		case R.id.spComensal1:
			comensal1Seleccionado = posicion;
			break;
		case R.id.spComensal2:
			comensal2Seleccionado = posicion;
			break;
		default:
			break;
		}
				
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
	
	
	public class EndPointNuevaReservaTask extends AsyncTask<Reserva, Integer, Reserva> {
						
		
		public EndPointNuevaReservaTask(){
			
		}

		protected Reserva doInBackground(Reserva... reservas) {
			
			Reserva resultado = null;		
			
			Reservaendpoint.Builder endpointBuilder = new Reservaendpoint.Builder(
					AndroidHttp.newCompatibleTransport(),
					new JacksonFactory(),
					credenciales);
										
			Reservaendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build();
			

			try {
								
				resultado = endpoint.insertReserva(reservas[0]).execute();				

			} catch (IOException e) {
				Log.e(TAG, e.getMessage());            
			}
			return resultado;
		}

		@Override
		protected void onPostExecute(Reserva resultado) {
			super.onPostExecute(resultado);		
			if (resultado!=null){
				Toast.makeText(contexto, "Reserva realizada con éxito: " + resultado.getId(), Toast.LENGTH_LONG).show();
			}
		}
	}

	 

}
