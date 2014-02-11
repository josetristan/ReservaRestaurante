package com.jtristan.reservarestaurante.ui;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.entidad.ofertaendpoint.model.Oferta;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;
import com.jtristan.reservarestaurante.thread.EndPointOfertaTask;
import com.jtristan.reservarestaurante.thread.EndPointRestauranteTask;

/**
 * Muestra todas las ofertas en un listview. Si seleccionas una de ellas te muestra 
 * el restaurante o restaurantes que la tienen.
 * @author josemaria.tristan
 *
 */
public class OfertaActivity extends Activity implements AdapterView.OnItemClickListener{
		
	private final static String TAG = OfertaActivity.class.getSimpleName();
	public final static String BUNDLE_ID_OFERTA = "com.jtristan.reservarestaurante.ui.OfertaActivity.ID";
	
	ListView listView;	
	static List<Oferta> ofertas = new ArrayList<Oferta>();
	static Activity contexto;
	//EndPointRestauranteConOfertaTask endPointRestauranteConOfertaTask;
	EndPointRestauranteTask endPointRestauranteTask;
	static Restaurante restaurante;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurantes);
		
		contexto = this;
		listView = (ListView)this.findViewById(R.id.listView);
				
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[0]);
    	listView.setAdapter(adaptador); 
    	listView.setOnItemClickListener(this);
    	
    	
    	    	    
		EndPointOfertaTask endPointOfertaTask = new EndPointOfertaTask(new EndPointOfertaTask.AsyncTaskListener() {
			
			@Override
			public void onProgressUpdate() {}
			
			@Override
			public void onInit() {}
			
			@Override
			public void onFinish(List<Oferta> ofertas) {
				String[] arrayOfertas = new String[ofertas.size()];
				int i=0;
				OfertaActivity.ofertas = ofertas;
				for (Oferta oferta: ofertas){
					arrayOfertas[i] = oferta.getDescripcion();
					i++;
				}
		    	listView.setAdapter(new ArrayAdapter<String>(OfertaActivity.contexto, android.R.layout.simple_spinner_item, arrayOfertas));    				
			}
			
			@Override
			public void onCancel() {}
		});
		
		endPointOfertaTask.execute();
		
		
		endPointRestauranteTask = new EndPointRestauranteTask(new EndPointRestauranteTask.AsyncTaskListener() {
			
			@Override
			public void onProgressUpdate() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onInit() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish(
					List<com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante> restaurantes) {
				//se debe pasar la variable restaurante al fragment 
				//mediante el método setFragment(Bundle). Eso supone tener
				//que hacer que la clase Restaurante implemente la interfaz
				//parcelable.
				//Ver: http://www.javahispano.org/android/2012/2/9/paso-de-parametros-entre-actividades-en-android-la-interfaz.html
				if (restaurantes!=null && restaurantes.size()>0){
					OfertaActivity.restaurante = restaurantes.get(0);
				}				
				FragmentManager fragmentManager = contexto.getFragmentManager();						
				DialogoRestaurante dialogo = new DialogoRestaurante();
				dialogo.show(fragmentManager, "tagDialogo");								
			}
				
			
			
			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		/*endPointRestauranteConOfertaTask = new EndPointRestauranteConOfertaTask(new EndPointRestauranteConOfertaTask.AsyncTaskListener() {
			
			@Override
			public void onProgressUpdate() {}
			
			@Override
			public void onInit() {}
			
			@Override
			public void onFinish(Restaurante restaurante) {
				//se debe pasar la variable restaurante al fragment 
				//mediante el método setFragment(Bundle). Eso supone tener
				//que hacer que la clase Restaurante implemente la interfaz
				//parcelable.
				//Ver: http://www.javahispano.org/android/2012/2/9/paso-de-parametros-entre-actividades-en-android-la-interfaz.html
				OfertaActivity.restaurante = restaurante;
				FragmentManager fragmentManager = contexto.getFragmentManager();						
				DialogoRestaurante dialogo = new DialogoRestaurante();
				dialogo.show(fragmentManager, "tagDialogo");								
			}
			
			@Override
			public void onCancel() {}
		});
		*/
																		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	/**
	 * Click para ver la carta.
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		Oferta oferta = ofertas.get(position);
		//endPointRestauranteConOfertaTask.execute(oferta.getClave());
		endPointRestauranteTask.execute(oferta.getRestaurante().getId());
		
	}
	
	public static class DialogoRestaurante extends DialogFragment{
				
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			
			AlertDialog.Builder builder =
	                new AlertDialog.Builder(getActivity());
			
			builder.setMessage(OfertaActivity.restaurante.getNombre())
            .setTitle("Restaurante")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
				     dialog.cancel();					
				}
			});
			
			return builder.create();
		}
		
		
	}

	

}
