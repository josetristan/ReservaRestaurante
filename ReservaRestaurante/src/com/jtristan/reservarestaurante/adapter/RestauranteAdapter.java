package com.jtristan.reservarestaurante.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jtristan.reservarestaurante.R;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Direccion;
import com.jtristan.reservarestaurante.entidad.restauranteendpoint.model.Restaurante;

public class RestauranteAdapter extends ArrayAdapter<Restaurante>{

	List<Restaurante>restaurantes;
	Activity contexto;
	int idLayout;
	
	public RestauranteAdapter(Context context, int resource, List<Restaurante> objects) {
		super(context, resource, objects);
		this.restaurantes = objects;
		this.contexto = (Activity) context;
		this.idLayout = resource;		
	}

	static class ViewHolder{
		public TextView tvNombre;
		public RatingBar rbEstrellas;
		public TextView tvDireccion;       
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View fila = convertView;
		
		if (fila == null){
			LayoutInflater inflater = contexto.getLayoutInflater();
			fila = inflater.inflate(idLayout, null);
			
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.tvNombre = (TextView) fila.findViewById(R.id.tvNombre); 
			viewHolder.tvDireccion = (TextView) fila.findViewById(R.id.tvDireccion);			
			viewHolder.rbEstrellas = (RatingBar) fila.findViewById(R.id.rbEstrellas);
			viewHolder.rbEstrellas.setIsIndicator(true);
			
			fila.setTag(viewHolder);
			
		}
		
		ViewHolder viewHolder = (ViewHolder) fila.getTag();
		Restaurante restaurante = restaurantes.get(position);
		
		if (restaurante.getNombre()!=null)
			viewHolder.tvNombre.setText(restaurante.getNombre());		
		viewHolder.tvDireccion.setText(componerDireccion(restaurante.getDireccion()));
		if (restaurante.getEstrellas() != null)
			viewHolder.rbEstrellas.setRating(Float.valueOf(restaurante.getEstrellas()));
		
		
		return fila;
	}

	private CharSequence componerDireccion(Direccion direccion) {
		StringBuilder resultado = new StringBuilder();
		if (direccion!=null){
			if (direccion.getTipo()!=null)
				resultado.append(direccion.getTipo());					
			if (direccion.getDireccion()!=null){
				resultado.append(" ")
						 .append(direccion.getDireccion());
			}
			if (direccion.getNumero()!=null){	
				resultado.append(" ")
							.append(direccion.getNumero());
			}
		}
		return resultado.toString();
	}
	
	

}
