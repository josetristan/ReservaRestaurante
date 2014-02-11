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
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Carta;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Oferta;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Reserva;
import com.jtristan.reservarestaurante.entidad.reservaendpoint.model.Usuario;


public class ReservaAdapter extends ArrayAdapter<Reserva>{

	List<Reserva>reservas;
	Activity contexto;
	int idLayout;
	
	public ReservaAdapter(Context context, int resource, List<Reserva> objects) {
		super(context, resource, objects);
		this.reservas = objects;
		this.contexto = (Activity) context;
		this.idLayout = resource;		
	}

	static class ViewHolder{		
		public TextView tvNombreUsuario;
		public TextView tvIdReserva;
		public TextView tvFecha;
		public TextView tvNombreRestaurante;		
		public TextView tvCarta1;
		public TextView tvCarta2;
		public TextView tvOferta;	
		public TextView tvNombreComensal1;
		public TextView tvNombreComensal2;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View fila = convertView;
		int i=0;
		
		if (fila == null){
			LayoutInflater inflater = contexto.getLayoutInflater();
			fila = inflater.inflate(idLayout, null);
			
			ViewHolder viewHolder = new ViewHolder();								
			viewHolder.tvNombreUsuario = (TextView) fila.findViewById(R.id.tvNombreUsuario);
			viewHolder.tvIdReserva = (TextView) fila.findViewById(R.id.tvIdReserva); 
			viewHolder.tvFecha = (TextView) fila.findViewById(R.id.tvFecha);			
			viewHolder.tvNombreRestaurante = (TextView) fila.findViewById(R.id.tvNombreRestaurante);
			viewHolder.tvCarta1 = (TextView) fila.findViewById(R.id.tvCarta1);
			viewHolder.tvCarta2 = (TextView) fila.findViewById(R.id.tvCarta2);
			viewHolder.tvOferta = (TextView) fila.findViewById(R.id.tvOferta);
			viewHolder.tvNombreComensal1 = (TextView) fila.findViewById(R.id.tvNombreComensal1);
			viewHolder.tvNombreComensal2 = (TextView) fila.findViewById(R.id.tvNombreComensal2);
									
			fila.setTag(viewHolder);
			
		}
		
		ViewHolder viewHolder = (ViewHolder) fila.getTag();
		Reserva reserva = reservas.get(position);
				
		viewHolder.tvNombreUsuario.setText(reserva.getUsuario().getNombre());
		viewHolder.tvIdReserva.setText(reserva.getId().toString());			
		viewHolder.tvFecha.setText(reserva.getHoraReserva().toStringRfc3339());
		viewHolder.tvNombreRestaurante.setText(reserva.getRestaurante().getNombre());		
				
		for (Carta plato: reserva.getRestaurante().getCarta()){
			if (i==0){
				viewHolder.tvCarta1.setText(componerPlato(plato));
			}
			if (i==1){
				viewHolder.tvCarta2.setText(componerPlato(plato));
			}
		}	
		
		if (reserva.getRestaurante().getOfertas()!=null){
			for (Oferta oferta: reserva.getRestaurante().getOfertas()){
				if (i==0){
					viewHolder.tvCarta1.setText(oferta.getDescripcion());
				}
				if (i==1){
					viewHolder.tvCarta2.setText(oferta.getDescripcion());
				}
			}
		}
				
		
		i=0;
		for (Usuario usuario: reserva.getComensales()){
			if (i==0){
				viewHolder.tvNombreComensal1.setText(usuario.getNombre());
			}
			if (i==1){
				viewHolder.tvNombreComensal2.setText(usuario.getNombre());
			}
			i++;
		}
		
		
		
		return fila;
	}

	private CharSequence componerPlato(Carta plato) {
		StringBuilder cadena = new StringBuilder();
		cadena.append(plato.getTipoPlato()).append(" ")
				.append(plato.getNombre());
		return cadena;
	}	

}


	
