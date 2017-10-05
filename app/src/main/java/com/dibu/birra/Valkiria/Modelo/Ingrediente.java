package com.dibu.birra.Valkiria.Modelo;

public class Ingrediente {
	
	   int cantidad;
	   int tiempoIniCoc; //Minutos
	
	public void Ingrediente(){
		tiempoIniCoc=0;
		cantidad=0;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getTiempoIniCoc() {
		return tiempoIniCoc;
	}
	public void setTiempoIniCoc(int tiempo_ini_coc) {
		this.tiempoIniCoc = tiempo_ini_coc;
	}

	
}
