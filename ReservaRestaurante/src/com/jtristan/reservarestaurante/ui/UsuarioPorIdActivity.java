package com.jtristan.reservarestaurante.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.entidad.usuarioendpoint.model.Usuario;
import com.jtristan.reservarestaurante.thread.EndPointUsuarioPorIDTask;
import com.jtristan.reservarestaurante.thread.EndPointUsuarioPorIDTask.AsyncTaskListener;

public class UsuarioPorIdActivity extends Activity implements AsyncTaskListener, View.OnClickListener{
		
	private final static String TAG = UsuarioPorIdActivity.class.getSimpleName();
	private EditText etUsuario;
	private Button btAceptar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usuario_por_id);			
		
		etUsuario = (EditText)this.findViewById(R.id.etIdUsuario);
		btAceptar = (Button)this.findViewById(R.id.btAceptar);
		btAceptar.setOnClickListener(this);
																							
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
	public void onFinish(Usuario usuario) {
		    	
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.btAceptar:
				if (etUsuario.getId()!=0)
					new EndPointUsuarioPorIDTask(this).execute(new Long(etUsuario.getId()));
		}
		
		
	}

		

}
