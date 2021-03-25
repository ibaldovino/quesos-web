package model;

import java.io.Serializable;



public class Habijurado implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idHabjur;


	private String observHabjur;


	private Habilidade habilidade;


	private Jurado jurado;

	public Habijurado() {
	}

	public long getIdHabjur() {
		return this.idHabjur;
	}

	public void setIdHabjur(long idHabjur) {
		this.idHabjur = idHabjur;
	}

	public String getObservHabjur() {
		return this.observHabjur;
	}

	public void setObservHabjur(String observHabjur) {
		this.observHabjur = observHabjur;
	}

	public Habilidade getHabilidade() {
		return this.habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

}