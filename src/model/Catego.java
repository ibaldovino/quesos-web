package model;

import java.io.Serializable;

public class Catego implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 483419298336739522L;
	
    private String descrip;

	
	private String identCateg;

	
	private String referencia;
	
	private long idCateg;


	public String getDescrip() {
		return descrip;
	}


	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	public String getIdentCateg() {
		return identCateg;
	}


	public void setIdentCateg(String identCateg) {
		this.identCateg = identCateg;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public long getIdCateg() {
		return idCateg;
	}


	public void setIdCateg(long idCateg) {
		this.idCateg = idCateg;
	}


	@Override
	public String toString() {
		return "Catego [idCateg=" + idCateg + ", descrip=" + descrip + ", identCateg=" + identCateg + ", referencia="
				+ referencia + "]";
	}
	
	
	

}
