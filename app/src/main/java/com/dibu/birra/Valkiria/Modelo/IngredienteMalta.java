package com.dibu.birra.Valkiria.Modelo;

public class IngredienteMalta extends Ingrediente implements IngredienteCerveza {
	Malta malta;

	
	public void IngredienteMalta(){
		malta = new Malta();
	}
	
	public Malta getMalta() {
		return malta;
	}

	public void setMalta(Malta malta) {
		this.malta = malta;
	}
	
	public String getDescrip(){
		return malta.getDescrip();
	}
	
}
