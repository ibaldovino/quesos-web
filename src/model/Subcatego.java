package model;

import java.io.Serializable;
import java.util.List;




public class Subcatego implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	private long idSubcateg;

	private String descrip;

	private String identScat;

	private String referencia;
	
	private List<Queso> quesos;
	 

	public Subcatego() {
	}

	public long getIdSubcateg() {
		return this.idSubcateg;
	}

	public void setIdSubcateg(long idSubcateg) {
		this.idSubcateg = idSubcateg;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getIdentScat() {
		return this.identScat;
	}

	public void setIdentScat(String identScat) {
		this.identScat = identScat;
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
	  queso.setSubcatego(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setSubcatego(null);
	  
	  return queso; }
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}