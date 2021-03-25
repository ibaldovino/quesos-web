package model;

import java.io.Serializable;

import java.util.List;


public class Habilidade implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long idHabili;


	private String desHabildad;


	private List<Habijurado> habijurados;

	public Habilidade() {
	}

	public long getIdHabili() {
		return this.idHabili;
	}

	public void setIdHabili(long idHabili) {
		this.idHabili = idHabili;
	}

	public String getDesHabildad() {
		return this.desHabildad;
	}

	public void setDesHabildad(String desHabildad) {
		this.desHabildad = desHabildad;
	}

	public List<Habijurado> getHabijurados() {
		return this.habijurados;
	}

	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}

	public Habijurado addHabijurado(Habijurado habijurado) {
		getHabijurados().add(habijurado);
		habijurado.setHabilidade(this);

		return habijurado;
	}

	public Habijurado removeHabijurado(Habijurado habijurado) {
		getHabijurados().remove(habijurado);
		habijurado.setHabilidade(null);

		return habijurado;
	}

}