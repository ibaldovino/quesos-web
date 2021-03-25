package model;

import java.io.Serializable;
import java.util.List;



public class Tipoleche implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idTiplec;

	private String nombre;

	private String referencia;
	
	private List<Queso> quesos;
	 

	public Tipoleche() {
	}

	public long getIdTiplec() {
		return this.idTiplec;
	}

	public void setIdTiplec(long idTiplec) {
		this.idTiplec = idTiplec;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	  queso.setTipoleche(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setTipoleche(null);
	  
	  return queso; }
	 

}