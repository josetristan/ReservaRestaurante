package com.jtristan.reservarestaurante.ui;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.jtristan.reservarestaurante.Ids;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class LoginActivity extends Activity {
	
	private final static String TAG = NuevaReservaActivity.class.getSimpleName();
	private final static int RECOGER_SOLICITUD_CUENTA = 1;
	private final static String NOMBRE_FICHERO_PREFERENCIAS = "Preferencias";
	
	private static final String PREF_NOMBRE_CUENTA = "nombreCuenta";	
	private SharedPreferences preferencias;	
	private GoogleAccountCredential credenciales;
	private String nombreCuenta;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		obtenerCredenciales();
		
	}
	
	
	private void obtenerCredenciales() {
		credenciales = GoogleAccountCredential.usingAudience(this, "server:client_id:"+Ids.WEB_CLIENT_ID);
		//preferencias = this.getPreferences(Context.MODE_PRIVATE);
		preferencias = this.getSharedPreferences(NOMBRE_FICHERO_PREFERENCIAS, Context.MODE_PRIVATE);
		if (preferencias.getString(PREF_NOMBRE_CUENTA, "")==""){
			seleccionarCuenta();
		}else{
			credenciales.setSelectedAccountName(preferencias.getString(PREF_NOMBRE_CUENTA, ""));			
		}		
		
	}
	
	private void seleccionarCuenta() {
		 startActivityForResult(credenciales.newChooseAccountIntent(), RECOGER_SOLICITUD_CUENTA);
	 }
	
	@Override protected void onActivityResult(int  requestCode,  int  resultCode,  Intent  data)  {          
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

	private void setNombreCuenta(String nombreCuenta) {
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putString(PREF_NOMBRE_CUENTA, nombreCuenta);
		editor.commit();
		credenciales.setSelectedAccountName(nombreCuenta);
		this.nombreCuenta = nombreCuenta;
	}


}
