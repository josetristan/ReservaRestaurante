package com.jtristan.reservarestaurante.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.adapter.RestauranteAdapter;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;
import com.jtristan.reservarestaurante.thread.EndPointRestauranteTask;
import com.jtristan.reservarestaurante.thread.EndPointRestauranteTask.AsyncTaskListener;

public class RestauranteConOfertaActivity extends Activity implements AsyncTaskListener,OnItemClickListener{
		
	private final static String TAG = RestauranteConOfertaActivity.class.getSimpleName();
	ListView listView;	
	List<Restaurante> restaurantes = new ArrayList<Restaurante>();
	RestauranteAdapter adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurantes);
		
		listView = (ListView)this.findViewById(R.id.listView);
		
		adaptador = new RestauranteAdapter(this, R.layout.restaurante_adapter, restaurantes);
    	listView.setAdapter(adaptador); 
    	listView.setOnItemClickListener(this);
    	    	    
		//new EndPointRestauranteConOfertaTask(this).execute(this);
																		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProgressUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
    	listView.setAdapter(new RestauranteAdapter(this, R.layout.restaurante_adapter, restaurantes));    	
		
	}
	
	/**
	 * Click para ver la carta.
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		
		
	}
	
		

}
