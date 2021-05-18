package model;

import java.io.Serializable;
import java.util.List;


public class Evadescrip implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idDescript;

	private String descrDescript;

	
	private Evatipo evatipo;

	private List<Evaluacione> evaluaciones;

	public Evadescrip() {
	}

	public long getIdDescript() {
		return this.idDescript;
	}

	public void setIdDescript(long idDescript) {
		this.idDescript = idDescript;
	}

	public String getDescrDescript() {
		return this.descrDescript;
	}

	public void setDescrDescript(String descrDescript) {
		this.descrDescript = descrDescript;
	}

	public Evatipo getEvatipo() {
		return this.evatipo;
	}

	public void setEvatipo(Evatipo evatipo) {
		this.evatipo = evatipo;
	}

	public List<Evaluacione> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacione addEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setEvadescrip(this);

		return evaluacione;
	}

	public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setEvadescrip(null);

		return evaluacione;
	}

}