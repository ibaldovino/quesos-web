package model;

import java.io.Serializable;



public class Mesajura implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idMesjur;

	private String funcion;

	private String observMesjur;


	private Jurado jurado;

	private Mesa mesa;

	public Mesajura() {
	}

	public long getIdMesjur() {
		return this.idMesjur;
	}

	public void setIdMesjur(long idMesjur) {
		this.idMesjur = idMesjur;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getObservMesjur() {
		return this.observMesjur;
	}

	public void setObservMesjur(String observMesjur) {
		this.observMesjur = observMesjur;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}