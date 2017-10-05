package com.dibu.birra.Valkiria.Modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Coccion {

	Cerveza cerveza;
	
	EquipoCocinado equipoCocinado;
	
	Date aguaIniRecoleccion; //Hora inicio recoleccion agua.- 
	double  aguaCanti = 0;      //Cantidad de agua recolectada.-
	double  aguaCantiLoop = 0;	 //litros a cargar en la vuelta.-
	
	Date calentarIniAguaMosto;
	Date calentarIniAguaLavado;
	
	Date lavadoGranoIni;
	
	Date IniMaltaEnAgua;         // Hora a la que puse maltas en agua.-
	Date calentarIniMosto;       // Inicio de calentado de mosto hasta que rompe hervor.-
	Date HervorIniMosto;         // Inicio de hervor. Minuto CERO de la coccion.-
	
	/*
	 * 0 - calcular llenado de litros agua Filtrada.- 
	 * 1 - caliento agua Mosoto => disparo alarma
	 * 2.1 - pongo Malta y espero 1 hora =>  disparo alarma
	 * 2.2 - caliento agua Lavado => disparo alarma
	 * 3.1 - lavado - 25min => disparo alarma
	 * 3.2 - caliento mosto a fuego lento disparo alarma  ///NO LO HAGO XQ NBO TENGO LOS TIEMPOS !!!
	 * 4 - caliento mosto + lavado =>  disparo alarma
	 * 5 - hervor: 1 hora de cocinado => disparo alarmas de Lupulo y IrishMoss.-
	 
	 * ESTOS LOS VEMOS LUEGO......
	 * 6 - Recordar de Higienizar el Fermentador.-
	 * 7 - Recordar de Higienizar el enfriador.-
	 * 8 - armado Equipo enfriado: => disparo alarmas 15 minutos antes de fin de hervor
	 */

	//*********************************************************************************
	/*                         ACTIVITIES
	 * a) Mostrar Ingredientes para Mosto
	 * b) Mostrar Ingredientes Inicio Hervor
	 * c) Mostrar 
	 * 
	 * 
	 * 
	 * 0 - calcular llenado de litros agua Filtrada.- 
	 * 		--Recolectando: Agua para Mosto
	 * 				Activity: -boton inicio Recoleccion       => lanzar alarma con texto: "RECOLECCION Agua para Mosto - Tanque 'n' LLENO !! "
	 * 						  -boton deshacer vuelta => toast => "FAVOR BORRAR alarma 'Tanque n LLENO' "
	 * 						  - texto: llenando bidon N / Total.- 
	 * 
	 * 		--Recolectando: Agua para lavar Grano 
	 * 				Activity: -boton inicio Recoleccion       => lanzar alarma con texto: "RECOLECCION Agua para Lavado Grrano - Tanque 'n' LLENO !! "
	 * 						  -boton deshacer vuelta => toast => "FAVOR BORRAR alarma 'Tanque n LLENO' "
	 * 						  - texto: llenando bidon N / Total.- 
	 *  
	 * 1 - caliento agua Mosoto => disparo alarma
	 * 				Activity: -boton inicio Calentamiento      => lanzar alarma con texto: "Agua para Mosto - CALENTADA !! "
	 * 						  -boton agregar minutos           => lanzar alarma con texto: "Agua para Mosto - n minutos agragados !! "
	 * 						  - Input numerico con minutos a agregar
	 * 						  - texto con actividad: caletantando o se agrego n minutos.-
	 * 						  - texto : Proceso Iniciado a las: HH:mm .
	 *   
	 * 2.1 - pongo Malta y espero 1 hora =>  disparo alarma
	 * 				Activity: -boton inicio                    => lanzar alarma con texto: "Mosto Preparado !! "
	 * 						  - texto : Proceso Iniciado a las: HH:mm .
	 *  
	 * 2.2 - caliento agua Lavado => disparo alarma
	 * 				Activity: -boton inicio Calentamiento      => lanzar alarma con texto: "Agua para Lavado Grano - CALENTADA !! "
	 * 						  -boton agregar minutos           => lanzar alarma con texto: "Agua para Lavado Grano - n minutos agragados !! "
	 * 						  - Input numerico con minutos a agregar
	 * 						  - texto con actividad: caletantando o se agrego n minutos.-
	 * 						  - texto : Proceso Iniciado a las: HH:mm .  
	 * 
	 * 3.1 - lavado - 25min => disparo alarma
	 * 				Activity: -boton inicio                    => lanzar alarma con texto: "Lavado de Grano FINALIZADO !! "
	 * 						  - texto : Proceso Iniciado a las: HH:mm . 
	 * 
	 * 3.2 - caliento mosto a fuego lento disparo alarma  ///NO LO HAGO XQ NBO TENGO LOS TIEMPOS !!!
	 * 4 - caliento mosto + lavado =>  disparo alarma
	 * 				Activity: -boton inicio                    => lanzar alarma con texto: "El MOSTO rompio Hervor !! "
	 * 5 - hervor: 1 hora de cocinado => disparo alarmas de Lupulo y IrishMoss.-
	 * 				Activity: -boton inicio                    => lanzar n alarmas con texto: "INGREDIENTES: Agregar 'x'. Cantidad: 'x' "
	 * 						  - texto : Proceso Iniciado a las: HH:mm . 
	 * 						  - Lista con ingredientes y hora de agregado (HH:mm). 
	 *
	 * ESTOS LOS VEMOS LUEGO......
	 * 6 - Recordar de Higienizar el Fermentador.-
	 * 7 - Recordar de Higienizar el enfriador.-
	 * 8 - armado Equipo enfriado: => disparo alarmas 15 minutos antes de fin de hervor
	*/
	//*********************************************************************************
	

	
	
	
    //*******************************************************************************
	//  0 - Procedo de Recoleccion de Agua Filtrada para cocinar.-
    //*******************************************************************************
	
	public void aguaCargaInicializar(){
		aguaCanti = 0;
	}
	
	public boolean aguaMostoCargaLoop(){
		return aguaCargaLoop(cerveza.getReceta().getAguaCantiMosto());
	}
	
	public boolean aguaLavadoCargaLoop(){
		return aguaCargaLoop(cerveza.getReceta().getAguaCantiLavado());
	}
	
	public boolean aguaCargaLoop( double cantidadTotal){
		//cada vez q se aprieta boton de carga agua se incremeta aguaCanti.-
		if( aguaCanti < cantidadTotal ){
			if ( (cantidadTotal - aguaCanti) <= equipoCocinado.getCapacidadFermentador()){
				aguaCantiLoop = equipoCocinado.getCapacidadFermentador();
			} else {
				aguaCantiLoop = (cantidadTotal - aguaCanti);
			}
			aguaCanti += aguaCantiLoop;
			return true;
		} else {
			return false;
		}
	}
	
	public double aguaCargaTimerGet(){

		//Devuelve "Minutos" que demora en llenar 1 fermentador o fraccion con agua.-
		return (equipoCocinado.getTmpCargaAgua()*aguaCantiLoop); //Minutos x litro		
	}
	
	
    //*******************************************************************************
	//  1 - Procedo de Calentar Agua para Hacer Mosto .-
    //*******************************************************************************
	
	public void calentarAguaMostoIniciar(){
		calentarIniAguaMosto = new Date();
	}

	public Date calentarAguaMostoTimerGet(){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calentarIniAguaMosto);
		
		calendar.add(Calendar.SECOND, equipoCocinado.getTiempoCalentarAguaMosto());
		
		return calendar.getTime();
	}
	
    //*******************************************************************************
	//  2.1 - pongo Malta y espero 1 hora =>  disparo alarma .-
    //*******************************************************************************
	public void maltaEnAguaIniciar(){
		IniMaltaEnAgua = new Date();
	}
	
	public Date maltaEnAguaTimerGet(){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(IniMaltaEnAgua);
		
		calendar.add(Calendar.SECOND, cerveza.getReceta().getTiempo_MaltaEnAgua());
		
		return calendar.getTime();
	}

    //*******************************************************************************
	//  2.2 - caliento agua Lavado => disparo alarma.-
    //*******************************************************************************
	public void calentarAguaLavadoIniciar(){
		calentarIniAguaLavado = new Date();
	}
	
	public Date calentarAguaLavadoTimerGet(){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calentarIniAguaLavado);
		
		calendar.add(Calendar.SECOND, equipoCocinado.getTiempoCalentarAguaLavado());
		
		return calendar.getTime();
	}

    //*******************************************************************************
	//  * 3.1 - lavado - 25min => disparo alarma.-
    //*******************************************************************************
	public void lavadoGranoIniciar(){
		lavadoGranoIni = new Date();
	}
	
	public Date lavadoGranoTimerGet( int cual){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(lavadoGranoIni);
		
		calendar.add(Calendar.SECOND, cerveza.getReceta().getTiempo_lavado_grano());
		
		return calendar.getTime();
	}
	
	
    //*******************************************************************************
	//  * 4 - caliento mosto + lavado =>  disparo alarma.-
    //*******************************************************************************
			
	public void calentarMostoIniciar(){
		calentarIniMosto = new Date();
	}
	
	public Date calentarMostoTimerGet(){

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calentarIniMosto);
		
		calendar.add(Calendar.SECOND, equipoCocinado.getTiempoMostoHervor());
		
		return calendar.getTime();
	}
	
    //*******************************************************************************
	//  * 5 - hervor: 1 hora de cocinado => disparo alarmas de Lupulo y IrishMoss.-
    //*******************************************************************************
	
	public void hervorMostoIniciar(){ 
		HervorIniMosto = new Date();
		
		//cerveza.getReceta().getIngredientes()
	}
	

	//Metodo que devuelve Lista de Ingredientes con tiempo de coccion > 0
	//a estos elementos les tengo que setear Alarma usando " hervorMostoIngredienteTimerGet(cual) "
	public List<Date> ingredienteHervidoTimerGet(){
		
		List<Date> listaHorarios = new ArrayList<Date>();
		List<IngredienteCerveza> ingredientes = cerveza.getReceta().getIngredientesCoccion();
		
		Ingrediente ingrediente;
		Calendar calendar = Calendar.getInstance();
		
		Iterator<IngredienteCerveza> it = ingredientes.iterator();

		while (it.hasNext()) {			
			ingrediente = (Ingrediente) it.next();
			calendar.setTime(HervorIniMosto);
			calendar.add(Calendar.MINUTE, ingrediente.getTiempoIniCoc());
			listaHorarios.add(calendar.getTime());
		}
		
		return listaHorarios;
	}
	
	//Metodo que devuelve Lista de Ingredientes con tiempo de coccion == 0
	//a estos elementos los tengo que listar para leerlos cuando sea necesario"
	public List<IngredienteCerveza> ingredientesMostoGet(){
		
		return cerveza.getReceta().getIngredientesMalta();
		
	}	
	
	
	
	
	// ***********************************************
	// ************** Getters & Setters ************** 
	// ***********************************************
	public void Coccion(){
		equipoCocinado = new EquipoCocinado();
	}

	public Cerveza getCerveza() {
		return cerveza;
	}

	public void setCerveza(Cerveza cerveza) {
		this.cerveza = cerveza;
	}

	public EquipoCocinado getEquipoCocinado() {
		return equipoCocinado;
	}

	public void setEquipoCocinado(EquipoCocinado equipoCocinado) {
		this.equipoCocinado = equipoCocinado;
	}

	public Date getAguaIniRecoleccion() {
		return aguaIniRecoleccion;
	}

	public void setAguaIniRecoleccion(Date aguaIniRecoleccion) {
		this.aguaIniRecoleccion = aguaIniRecoleccion;
	}

	public double getAguaCanti() {
		return aguaCanti;
	}

	public void setAguaCanti(double aguaCanti) {
		this.aguaCanti = aguaCanti;
	}

	public Date getCalentarIniAguaMosto() {
		return calentarIniAguaMosto;
	}

	public void setCalentarIniAguaMosto(Date calentarIniAguaMosto) {
		this.calentarIniAguaMosto = calentarIniAguaMosto;
	}

	public Date getCalentarIniAguaLavado() {
		return calentarIniAguaLavado;
	}

	public void setCalentarIniAguaLavado(Date calentarIniAguaLavado) {
		this.calentarIniAguaLavado = calentarIniAguaLavado;
	}

	public Date getIniMaltaEnAgua() {
		return IniMaltaEnAgua;
	}

	public void setIniMaltaEnAgua(Date iniMaltaEnAgua) {
		IniMaltaEnAgua = iniMaltaEnAgua;
	}

	public Date getCalentarIniMosto() {
		return calentarIniMosto;
	}

	public void setCalentarIniMosto(Date calentarIniMosto) {
		this.calentarIniMosto = calentarIniMosto;
	}

	public Date getHervorIniMosto() {
		return HervorIniMosto;
	}

	public void setHervorIniMosto(Date hervorIniMosto) {
		HervorIniMosto = hervorIniMosto;
	}
	
	
}
