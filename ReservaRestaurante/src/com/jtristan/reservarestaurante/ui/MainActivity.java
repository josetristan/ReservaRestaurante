package com.jtristan.reservarestaurante.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.RegisterActivity;


public class MainActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button btLoguearse = (Button)this.findViewById(R.id.btLoguearse);
		Button btConsultarRestaurante = (Button)this.findViewById(R.id.btConsultarRestaurante);
		Button btConsularReserva = (Button)this.findViewById(R.id.btConsularReserva);
		Button btConsultarOferta = (Button)this.findViewById(R.id.btConsultarOferta);
		Button btNuevaReserva = (Button)this.findViewById(R.id.btNuevaReserva);
		Button btConsultarUsuarioPorID = (Button)this.findViewById(R.id.btConsultarUsuarioPorID);
		Button btRegistrar = (Button)this.findViewById(R.id.btRegistrar);
				
		
		btLoguearse.setOnClickListener(this);
	    btConsultarRestaurante.setOnClickListener(this);
	    btConsularReserva.setOnClickListener(this);
	    btConsultarOferta.setOnClickListener(this);    
	    btNuevaReserva.setOnClickListener(this);
	    btConsultarUsuarioPorID.setOnClickListener(this);
	    btRegistrar.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	@Override
	public void onClick(View view) {
		Intent intent = new Intent();
		switch(view.getId()){
		case R.id.btLoguearse:
			 intent = new Intent(this,LoginActivity.class);
			 break;
		case R.id.btConsultarRestaurante:
			 intent = new Intent(this,RestauranteActivity.class);
			 break;
		case R.id.btConsularReserva:
			 intent = new Intent(this,ReservaActivity.class);
			 break;
		case R.id.btConsultarOferta:
			 intent = new Intent(this,OfertaActivity.class);
			 break;
		case R.id.btNuevaReserva:
			 intent = new Intent(this,NuevaReservaActivity.class);
			 break;	
		case R.id.btConsultarUsuarioPorID:
			intent = new Intent(this, UsuarioPorIdActivity.class);
			break;
		case R.id.btRegistrar:
			intent = new Intent(this, RegisterActivity.class);
			break;
		}
		this.startActivity(intent);
		
	}

}
