package com.dibu.birra.Valkiria.Modelo;

import java.io.Serializable;

public class Cerveza implements Serializable   {
	private int id;
	private String descrip;
	private int foto;
	private Receta receta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int getFoto() {
		return foto;
	}
	public void setFoto(int foto) {
		this.foto = foto;
	}
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
}
