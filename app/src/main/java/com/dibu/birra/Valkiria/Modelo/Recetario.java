package com.dibu.birra.Valkiria.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Recetario {

	List<Cerveza> cervezas;
	
	List<Lupulo> lupulos;
	static int CASCADE = 0;
	static int KENTGOLDIN = 1;
	
	List<Presipitador> presipitadores;
	static int IRISHMOSS = 0;
	
	List<Malta> maltas;
	static int PILSEN = 0;
	static int CARAMELO60 = 1;
	static int NEGRA = 2;
	static int MELANOIDINA = 3;
	static int CARAMELO140 = 4;
	static int AVENA = 5;
	
	public  Recetario(){
		
		//Lleno con mis recetas.-
		cervezas = new ArrayList<Cerveza>();
		lupulos = new ArrayList<Lupulo>();
        maltas = new ArrayList<Malta>();
		presipitadores = new ArrayList<Presipitador>();
		
	}
	
	public void init(){
		
		cargarMaltas();
		cargarLupulos();
		cargarPresipitadores();
		
		cargarCervezas();
	}
	
	private void cargarCervezas(){
		AgregarIPA();
		AgregarROJA();
		AgregarSTOUT();
	}
	
	private void cargarLupulos(){
		
		Lupulo lupuloCascade = new Lupulo(); //CASCADE = 1;
		lupuloCascade.setId(1);
		lupuloCascade.setDescrip("Casacade");
		lupuloCascade.setIBU(7); //ver q IBU tiene.
		lupulos.add(lupuloCascade);
		
		Lupulo lupuloKentGolding = new Lupulo(); //KENTGOLDIN = 2;
		lupuloCascade.setId(2);
		lupuloCascade.setDescrip("Kent Golding");
		lupuloCascade.setIBU(14); //ver q IBU tiene.
		lupulos.add(lupuloKentGolding);
		
		
	}
	
	private void cargarPresipitadores(){
		
		Presipitador presipitador = new Presipitador();
		presipitador.setId(1);
		presipitador.setDescripcion("Irish Moss");
		presipitadores.add(presipitador);
		
	}
	
	private void cargarMaltas(){
		Malta malta;
		
		malta = new Malta(); //PILSEN
		malta.setId(1);
		malta.setDescrip("Pilsen base");

		maltas.add(malta);
		
		
		malta = new Malta(); //CARAMELO60
		malta.setId(2);
		malta.setDescrip("Caramelo 60");
		maltas.add(malta);
		
		malta = new Malta(); //NEGRA
		malta.setId(3);
		malta.setDescrip("Malta negra");
		maltas.add(malta);
		
		malta = new Malta(); //MELANOIDINA
		malta.setId(4);
		malta.setDescrip("Malta Melanoidina");
		maltas.add(malta);
		
		malta = new Malta(); //CARAMELO140
		malta.setId(5);
		malta.setDescrip("Caramelo 140");
		maltas.add(malta);

		malta = new Malta(); //Avena
		malta.setId(6);
		malta.setDescrip("Avena");
		maltas.add(malta);
	}
		
	private void AgregarIPA(){
		
		Receta receta = new Receta(0); //Litros a hacer.-

		receta.setTiempo_tot_hervido(60);
		
		List<IngredienteCerveza> listaIngredientes = new ArrayList<IngredienteCerveza>();
		
		IngredienteLupulo ingredientelupulo;
		
		//lupuloAmargor1
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(10);
		ingredientelupulo.setTiempoIniCoc(0); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(CASCADE));
		listaIngredientes.add(ingredientelupulo);
		
		
		//lupuloAmargor2
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(10);
		ingredientelupulo.setTiempoIniCoc(15); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(CASCADE));
		listaIngredientes.add(ingredientelupulo);
		

		//lupuloSabor
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(5);
		ingredientelupulo.setTiempoIniCoc(40); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(KENTGOLDIN));
		listaIngredientes.add(ingredientelupulo);
		
		//lupuloAroma
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(5);
		ingredientelupulo.setTiempoIniCoc(55); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(KENTGOLDIN));
		listaIngredientes.add(ingredientelupulo);
		
		
		IngredientePresipitador ingredientePresipitador;
		
		//irishMoss
		ingredientePresipitador = new IngredientePresipitador();
		ingredientePresipitador.setCantidad(1);
		ingredientePresipitador.setTiempoIniCoc(50); //minutos.-
		ingredientePresipitador.setPresipitador(presipitadores.get(IRISHMOSS));
		listaIngredientes.add(ingredientePresipitador);
		
		
		IngredienteMalta malta;
		
		//Malta base.-
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(PILSEN));
		malta.setCantidad(2500); // gramos
		listaIngredientes.add(malta);
		
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(CARAMELO60));
		malta.setCantidad(200); // gramos
		listaIngredientes.add(malta);
		
		
		receta.setIngredientes(listaIngredientes);
		
		
		Cerveza cerveza = new Cerveza();
		cerveza.setId(1);
		cerveza.setDescrip("IPA");
		cerveza.setReceta(receta);		
		
		cervezas.add(cerveza);
	}
	
	
	private void AgregarROJA(){
		
		Receta receta = new Receta(0);

		receta.setTiempo_tot_hervido(60);
		
		List<IngredienteCerveza> listaIngredientes = new ArrayList<IngredienteCerveza>();
		
		IngredienteLupulo ingredientelupulo;

		
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(10);
		ingredientelupulo.setTiempoIniCoc(0); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(CASCADE));
		listaIngredientes.add(ingredientelupulo);

		IngredientePresipitador irishMoss;
		
		irishMoss = new IngredientePresipitador();
		irishMoss.setCantidad(1);
		irishMoss.setTiempoIniCoc(50); //minutos.-
		irishMoss.setPresipitador(presipitadores.get(IRISHMOSS));
		listaIngredientes.add(irishMoss);
		
		
		IngredienteMalta malta;
		
		//Malta base.-
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(PILSEN));
		malta.setCantidad(2500); // gramos
		listaIngredientes.add(malta);
		
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(CARAMELO60));
		malta.setCantidad(100); // gramos
		listaIngredientes.add(malta);
		
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(NEGRA));
		malta.setCantidad(25); // gramos
		listaIngredientes.add(malta);

		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(MELANOIDINA));
		malta.setCantidad(75); // gramos
		listaIngredientes.add(malta);
		
		receta.setIngredientes(listaIngredientes);
		
		
		Cerveza cerveza = new Cerveza();
		cerveza.setId(2);
		cerveza.setDescrip("Roja");
		cerveza.setReceta(receta);		
		
		cervezas.add(cerveza);
	}	
	
	
	private void AgregarSTOUT(){
		
		Receta receta = new Receta(0);

		receta.setTiempo_tot_hervido(60);
		
		List<IngredienteCerveza> listaIngredientes = new ArrayList<IngredienteCerveza>();
		
		IngredienteLupulo ingredientelupulo;
		
		
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(10);
		ingredientelupulo.setTiempoIniCoc(20); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(CASCADE));
		listaIngredientes.add(ingredientelupulo);
		
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(10);
		ingredientelupulo.setTiempoIniCoc(40); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(CASCADE));
		listaIngredientes.add(ingredientelupulo);
		
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(5);
		ingredientelupulo.setTiempoIniCoc(45); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(KENTGOLDIN));
		listaIngredientes.add(ingredientelupulo);
		
		ingredientelupulo = new IngredienteLupulo();
		ingredientelupulo.setCantidad(5);
		ingredientelupulo.setTiempoIniCoc(50); //minutos.-
		ingredientelupulo.setLupulo(lupulos.get(KENTGOLDIN));
		listaIngredientes.add(ingredientelupulo);
		
		IngredientePresipitador ingredientePresipitador;
		
		ingredientePresipitador = new IngredientePresipitador();
		ingredientePresipitador.setCantidad(1);
		ingredientePresipitador.setTiempoIniCoc(50); //minutos.-
		ingredientePresipitador.setPresipitador(presipitadores.get(IRISHMOSS));
		listaIngredientes.add(ingredientePresipitador);
		
		IngredienteMalta malta;
		
		//Malta base.-
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(PILSEN));
		malta.setCantidad(2500); // gramos
		listaIngredientes.add(malta);
		
		//
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(NEGRA));
		malta.setCantidad(200); // gramos
		listaIngredientes.add(malta);
		
		//
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(CARAMELO60));
		malta.setCantidad(100); // gramos
		listaIngredientes.add(malta);

		//
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(CARAMELO140));
		malta.setCantidad(100); // gramos
		listaIngredientes.add(malta);

		//
		malta = new IngredienteMalta();
		malta.setMalta(maltas.get(AVENA)); // maltas.get(5)
		malta.setCantidad(370); // gramos
		listaIngredientes.add(malta);
		
		receta.setIngredientes(listaIngredientes);
		
		
		Cerveza cerveza = new Cerveza();
		cerveza.setId(3);
		cerveza.setDescrip("STOUT");
		cerveza.setReceta(receta);		
		
		cervezas.add(cerveza);
	}
	
	
	
	/* GETTERs y SETTERs */

	public List<Cerveza> getCervezas() {
		return cervezas;
	}
	
	
	/* NO SE VA A USAR !!!!
	public void setCervezas(List<Cerveza> cervezas) {
		this.cervezas = cervezas;
	}

	 */
}
