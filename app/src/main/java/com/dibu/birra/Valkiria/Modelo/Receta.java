package com.dibu.birra.Valkiria.Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Receta {
	 
	int litros; //Litros de Cerveza a preparar (multiplos de 10)
	int tiempo_tot_hervido  = (int) Math.round( ((double) 60)   * ((double) 60) ); //Segundos que tiene que hervir el mosto
	int tiempo_MaltaEnAgua  = (int) Math.round( ((double) 60)   * ((double) 60) ); //Segundos de malta en el agua.-
	int tiempo_lavado_grano = (int) Math.round( ((double) 25)   * ((double) 60) ); //Segundos que tengo que lavar el grano
	List<IngredienteCerveza> ingredientes;
	 
	
	public Receta(int litros){this.litros = litros;}

	
	public List<IngredienteCerveza> getIngredientesMalta(){
		List<IngredienteCerveza> lista = new ArrayList<IngredienteCerveza>();
		
		Iterator<IngredienteCerveza> it = ingredientes.iterator();
		Ingrediente ingrediente;
		
		while (it.hasNext()) {			
			ingrediente = (Ingrediente) it.next();
			if( ingrediente instanceof IngredienteMalta ){
				lista.add( (IngredienteCerveza) ingrediente);
			}
		}
		
		return lista;
	};
	
	public List<IngredienteLupulo> getIngredientesLupulo(){
		List<IngredienteLupulo> lista = new ArrayList<IngredienteLupulo>();
		
		
		Iterator<IngredienteCerveza> it = ingredientes.iterator();
		Ingrediente ingrediente;
		
		while (it.hasNext()) {			
			ingrediente = (Ingrediente) it.next();
			if( ingrediente instanceof IngredienteLupulo ){
				lista.add( (IngredienteLupulo) ingrediente);
			}
		}
		
		return lista;				
	};
	
	public List<IngredientePresipitador> getIngredientesPresipitador(){
		List<IngredientePresipitador> lista = new ArrayList<IngredientePresipitador>();
		
		
		Iterator<IngredienteCerveza> it = ingredientes.iterator();
		Ingrediente ingrediente;
		
		while (it.hasNext()) {			
			ingrediente = (Ingrediente) it.next();
			if( ingrediente instanceof IngredientePresipitador ){
				lista.add( (IngredientePresipitador) ingrediente);
			}
		}
		
		return lista;		
	};
	
	public List<IngredienteCerveza> getIngredientesCoccion(){
		List<IngredienteCerveza> lista = new ArrayList<IngredienteCerveza>();
		
		Iterator<IngredienteCerveza> it = ingredientes.iterator();
		Ingrediente ingrediente;
		
		while (it.hasNext()) {			
			ingrediente = (Ingrediente) it.next();
			if( ingrediente instanceof IngredientePresipitador || ingrediente instanceof IngredienteLupulo ){
				lista.add( (IngredienteCerveza) ingrediente);
			}
		}
		
		return lista;			
	};
	
	public List<IngredientePresipitador> getIngredientesMosto(){
		List<IngredientePresipitador> lista= new ArrayList<IngredientePresipitador>();
		
		
		return lista;		
	};
	
	
	public double getAguaCantiMosto(){
		return calcularAguacantidad();
	}
	
	public double getAguaCantiLavado(){
		return calcularAguacantidad();
	}
	
	private double calcularAguacantidad(){
		return ( (litros*3)+ ((litros/10)*0.320) );
	}
	

	
	// ***********************************************
	// ************** Getters & Setters ************** 
	// ***********************************************
	
	public int getLitros() {
		return litros;
	}


	public void setLitros(int litros) {
		this.litros = litros;
	}


	public int getTiempo_tot_hervido() {
		return tiempo_tot_hervido;
	}


	public void setTiempo_tot_hervido(int tiempo_tot_hervido) {
		this.tiempo_tot_hervido = tiempo_tot_hervido;
	}


	public List<IngredienteCerveza> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(List<IngredienteCerveza> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public int getTiempo_lavado_grano() {
		return tiempo_lavado_grano;
	}


	public void setTiempo_lavado_grano(int tiempo_lavado_grano) {
		this.tiempo_lavado_grano = tiempo_lavado_grano;
	}


	public int getTiempo_MaltaEnAgua() {
		return tiempo_MaltaEnAgua;
	}


	public void setTiempo_MaltaEnAgua(int tiempo_tot_mosto) {
		this.tiempo_MaltaEnAgua = tiempo_tot_mosto;
	}


}
