package com.jtristan.reservarestaurante.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Carta;


public class CartaAdapter extends ArrayAdapter<Carta>{

	List<Carta>platos;
	Activity contexto;
	int idLayout;
	
	public CartaAdapter(Context context, int resource, List<Carta> objects) {
		super(context, resource, objects);
		this.platos = objects;
		this.contexto = (Activity) context;
		this.idLayout = resource;		
	}

	static class ViewHolder{
		public TextView tvTipo;
		public TextView tvPlato;
		public TextView tvPrecio;       
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View fila = convertView;
		
		if (fila == null){
			LayoutInflater inflater = contexto.getLayoutInflater();
			fila = inflater.inflate(idLayout, null);
			
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.tvTipo = (TextView) fila.findViewById(R.id.tvTipo); 
			viewHolder.tvPlato = (TextView) fila.findViewById(R.id.tvPlato);			
			viewHolder.tvPrecio = (TextView) fila.findViewById(R.id.tvPrecio);
						
			fila.setTag(viewHolder);
			
		}
		
		ViewHolder viewHolder = (ViewHolder) fila.getTag();
		Carta plato = platos.get(position);		
		
		if (plato.getTipoPlato()!=null)
			viewHolder.tvTipo.setText(plato.getTipoPlato());
		if (plato.getNombre()!=null)
			viewHolder.tvPlato.setText(plato.getNombre());
		if (plato.getPrecio()!=null)
			viewHolder.tvPrecio.setText(plato.getPrecio().toString());
						
		return fila;
	}
	

}
