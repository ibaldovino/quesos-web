package model;

import java.io.Serializable;
import java.util.List;



public class Variedad implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long idVar;

	private String nombreVar;

	private String referencia;

	 private List<Queso> quesos;
	 

	public Variedad() {
	}

	public long getIdVar() {
		return this.idVar;
	}

	public void setIdVar(long idVar) {
		this.idVar = idVar;
	}

	public String getNombreVar() {
		return this.nombreVar;
	}

	public void setNombreVar(String nombreVar) {
		this.nombreVar = nombreVar;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	
	  public List<Queso> getQuesos() { return this.quesos; }
	  
	  public void setQuesos(List<Queso> quesos) { this.quesos = quesos; }
	  
	  public Queso addQueso(Queso queso) { getQuesos().add(queso);
	  queso.setVariedad(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setVariedad(null);
	  
	  return queso; }
	 

}