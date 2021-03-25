package model;

import java.io.Serializable;
import java.util.List;



public class Maduracion implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idMadur;

	private String descrip;

	private String referencia;

	private List<Queso> quesos;
	 

	public Maduracion() {
	}

	public long getIdMadur() {
		return this.idMadur;
	}

	public void setIdMadur(long idMadur) {
		this.idMadur = idMadur;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
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
	  queso.setMaduracion(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setMaduracion(null);
	  
	  return queso; }
	 

}