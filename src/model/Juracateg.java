package model;

import java.io.Serializable;




public class Juracateg implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long idJurcat;

	
	private String observJurcat;


	private Categoria categoria;


	private Jurado jurado;

	public Juracateg() {
	}

	public long getIdJurcat() {
		return this.idJurcat;
	}

	public void setIdJurcat(long idJurcat) {
		this.idJurcat = idJurcat;
	}

	public String getObservJurcat() {
		return this.observJurcat;
	}

	public void setObservJurcat(String observJurcat) {
		this.observJurcat = observJurcat;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

}