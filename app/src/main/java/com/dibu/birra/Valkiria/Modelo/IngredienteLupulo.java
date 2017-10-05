package com.dibu.birra.Valkiria.Modelo;

public class IngredienteLupulo extends Ingrediente implements IngredienteCerveza {
	Lupulo lupulo;

	public IngredienteLupulo (){
		lupulo = new Lupulo();
	}
	
	public Lupulo getLupulo() {
		return lupulo;
	}

	public void setLupulo(Lupulo lupulo) {
		this.lupulo = lupulo;
	}

	public String getDescrip(){
		return lupulo.getDescrip();
	}

	
}
