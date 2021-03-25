package model;

import java.io.Serializable;
import java.util.List;


public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idMesa;

	private String nombreMesa;

	private String ubicacion;


	private List<Evaluacione> evaluaciones;


	private List<Mesajura> mesajuras;

	public Mesa() {
	}

	public long getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public String getNombreMesa() {
		return this.nombreMesa;
	}

	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Evaluacione> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacione addEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setMesa(this);

		return evaluacione;
	}

	public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setMesa(null);

		return evaluacione;
	}

	public List<Mesajura> getMesajuras() {
		return this.mesajuras;
	}

	public void setMesajuras(List<Mesajura> mesajuras) {
		this.mesajuras = mesajuras;
	}

	public Mesajura addMesajura(Mesajura mesajura) {
		getMesajuras().add(mesajura);
		mesajura.setMesa(this);

		return mesajura;
	}

	public Mesajura removeMesajura(Mesajura mesajura) {
		getMesajuras().remove(mesajura);
		mesajura.setMesa(null);

		return mesajura;
	}

}