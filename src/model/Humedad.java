package model;

import java.io.Serializable;
import java.util.List;




public class Humedad implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idHumed;

	private String descrip;

	private String referencia;

	private List<Queso> quesos;
	 

	public Humedad() {
	}

	public long getIdHumed() {
		return this.idHumed;
	}

	public void setIdHumed(long idHumed) {
		this.idHumed = idHumed;
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
	  queso.setHumedad(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setHumedad(null);
	  
	  return queso; }
	 

}