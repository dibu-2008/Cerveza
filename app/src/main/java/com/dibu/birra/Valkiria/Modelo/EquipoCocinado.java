package com.dibu.birra.Valkiria.Modelo;

/*
 * Aca se guardan los setting del equipo a usar.
 * 
 */

public class EquipoCocinado {

	double tmpCargaAgua = 1; // 1 minuto por litro.-
	int capacidadFermentador = 20; //litros.-
	
	int tiempoCalentarAguaMosto  = (int) Math.round( ((double) 20)   * ((double) 60) );  //SEGUNDOS para llegar a 64 grados.- 
	int tiempoCalentarAguaLavado = (int) Math.round( ((double) 23.5) * ((double) 60) );  //SEGUNDOS para llegar a 69 grados.- 
	int tiempoMostoHervor        = (int) Math.round( ((double) 15)   * ((double) 60) );  //SEGUNDOS para llegar romper hervor.- 
	
	
	public int getTiempoMostoHervor() {
		return tiempoMostoHervor;
	}

	public void setTiempoMostoHervor(int tiempoMostoHervor) {
		this.tiempoMostoHervor = tiempoMostoHervor;
	}

	public int getTiempoCalentarAguaMosto() {
		return tiempoCalentarAguaMosto;
	}

	public void setTiempoCalentarAguaMosto(int tiempoCalentarAguaMosto) {
		
		this.tiempoCalentarAguaMosto = tiempoCalentarAguaMosto;
	}

	public int getTiempoCalentarAguaLavado() {
		return tiempoCalentarAguaLavado;
	}

	public void setTiempoCalentarAguaLavado(int tiempoCalentarAguaLavado) {
		this.tiempoCalentarAguaLavado = tiempoCalentarAguaLavado;
	}

	public double getTmpCargaAgua() {
		return tmpCargaAgua;
	}

	public int getCapacidadFermentador() {
		return capacidadFermentador;
	}

	public void setCapacidadFermentador(int capacidadFermentador) {
		this.capacidadFermentador = capacidadFermentador;
	}

	public void setTmpCargaAgua(double tmpCargaAgua) {
		this.tmpCargaAgua = tmpCargaAgua;
	}
	
}
