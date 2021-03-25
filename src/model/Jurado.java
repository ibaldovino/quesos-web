package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class Jurado implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idJurado;
	
	private String nombre;

	private String apellido;

	private BigDecimal cedula;

	private String direccion;

	private String email;	

	private String telefonoCel;

	private List<Evaluacione> evaluaciones;

	private List<Habijurado> habijurados;

	private List<Juracateg> juracategs;

	private List<Mesajura> mesajuras;

	public Jurado() {
	}

	public long getIdJurado() {
		return this.idJurado;
	}

	public void setIdJurado(long idJurado) {
		this.idJurado = idJurado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getCedula() {
		return this.cedula;
	}

	public void setCedula(BigDecimal cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefonoCel() {
		return this.telefonoCel;
	}

	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}

	public List<Evaluacione> getEvaluaciones() {
		return this.evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evaluacione addEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().add(evaluacione);
		evaluacione.setJurado(this);

		return evaluacione;
	}

	public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
		getEvaluaciones().remove(evaluacione);
		evaluacione.setJurado(null);

		return evaluacione;
	}

	public List<Habijurado> getHabijurados() {
		return this.habijurados;
	}

	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}

	public Habijurado addHabijurado(Habijurado habijurado) {
		getHabijurados().add(habijurado);
		habijurado.setJurado(this);

		return habijurado;
	}

	public Habijurado removeHabijurado(Habijurado habijurado) {
		getHabijurados().remove(habijurado);
		habijurado.setJurado(null);

		return habijurado;
	}

	public List<Juracateg> getJuracategs() {
		return this.juracategs;
	}

	public void setJuracategs(List<Juracateg> juracategs) {
		this.juracategs = juracategs;
	}

	public Juracateg addJuracateg(Juracateg juracateg) {
		getJuracategs().add(juracateg);
		juracateg.setJurado(this);

		return juracateg;
	}

	public Juracateg removeJuracateg(Juracateg juracateg) {
		getJuracategs().remove(juracateg);
		juracateg.setJurado(null);

		return juracateg;
	}

	public List<Mesajura> getMesajuras() {
		return this.mesajuras;
	}

	public void setMesajuras(List<Mesajura> mesajuras) {
		this.mesajuras = mesajuras;
	}

	public Mesajura addMesajura(Mesajura mesajura) {
		getMesajuras().add(mesajura);
		mesajura.setJurado(this);

		return mesajura;
	}

	public Mesajura removeMesajura(Mesajura mesajura) {
		getMesajuras().remove(mesajura);
		mesajura.setJurado(null);

		return mesajura;
	}

}