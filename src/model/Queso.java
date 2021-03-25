package model;

import java.io.Serializable;
import java.util.List;




public class Queso implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idQueso;

	private String categenconcur;

	private String codigoAuto;

	private String descautom;

	private String descmanual;

	private List<Evaluacione> evaluaciones;
	
	private List<Inscripcione> inscripciones;

	private Categoria categoria;

	private Humedad humedad;

	private Maduracion maduracion;

	private Subcatego subcatego;

	private Tecnologia tecnologia;

	private Tipoleche tipoleche;

	private Variedad variedad;

	public Queso() {
	}

	public long getIdQueso() {
		return this.idQueso;
	}

	public void setIdQueso(long idQueso) {
		this.idQueso = idQueso;
	}

	public String getCategenconcur() {
		return this.categenconcur;
	}

	public void setCategenconcur(String categenconcur) {
		this.categenconcur = categenconcur;
	}

	public String getCodigoAuto() {
		return this.codigoAuto;
	}

	public void setCodigoAuto(String codigoAuto) {
		this.codigoAuto = codigoAuto;
	}

	public String getDescautom() {
		return this.descautom;
	}

	public void setDescautom(String descautom) {
		this.descautom = descautom;
	}

	public String getDescmanual() {
		return this.descmanual;
	}

	public void setDescmanual(String descmanual) {
		this.descmanual = descmanual;
	}

	
	  public List<Evaluacione> getEvaluaciones() { return this.evaluaciones; }
	  
	  public void setEvaluaciones(List<Evaluacione> evaluaciones) {
	  this.evaluaciones = evaluaciones; }
	  
	  
	  public Evaluacione addEvaluacione(Evaluacione evaluacione) {
	  getEvaluaciones().add(evaluacione); evaluacione.setQueso(this);
	  
	  return evaluacione; }
	  
	  public Evaluacione removeEvaluacione(Evaluacione evaluacione) {
	  getEvaluaciones().remove(evaluacione); evaluacione.setQueso(null);
	  
	  return evaluacione; }
	  
	  public List<Inscripcione> getInscripciones() { return this.inscripciones; }
	  
	  public void setInscripciones(List<Inscripcione> inscripciones) {
	  this.inscripciones = inscripciones; }
	  
	  public Inscripcione addInscripcione(Inscripcione inscripcione) {
	  getInscripciones().add(inscripcione); inscripcione.setQueso(this);
	  
	  return inscripcione; }
	  
	  public Inscripcione removeInscripcione(Inscripcione inscripcione) {
	  getInscripciones().remove(inscripcione); inscripcione.setQueso(null);
	  
	  return inscripcione; }
	 
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Humedad getHumedad() {
		return this.humedad;
	}

	public void setHumedad(Humedad humedad) {
		this.humedad = humedad;
	}

	public Maduracion getMaduracion() {
		return this.maduracion;
	}

	public void setMaduracion(Maduracion maduracion) {
		this.maduracion = maduracion;
	}

	public Subcatego getSubcatego() {
		return this.subcatego;
	}

	public void setSubcatego(Subcatego subcatego) {
		this.subcatego = subcatego;
	}

	public Tecnologia getTecnologia() {
		return this.tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Tipoleche getTipoleche() {
		return this.tipoleche;
	}

	public void setTipoleche(Tipoleche tipoleche) {
		this.tipoleche = tipoleche;
	}

	public Variedad getVariedad() {
		return this.variedad;
	}

	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}

}