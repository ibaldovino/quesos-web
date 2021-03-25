package model;

import java.io.Serializable;
import java.util.List;





public class Categoria extends Catego implements Serializable {
	private static final long serialVersionUID = 1L;


	private List<Juracateg> juracategs;
	  
	private List<Queso> quesos;
	 
	 

	public Categoria(List<Juracateg> juracategs, List<Queso> quesos) {
		super();
		this.juracategs = juracategs;
		this.quesos = quesos;
	}

	public Categoria() {
		
	}

		
	
	  public List<Juracateg> getJuracategs() { return this.juracategs; }
	  
	  public void setJuracategs(List<Juracateg> juracategs) { this.juracategs =
	  juracategs; }
	  
	  public Juracateg addJuracateg(Juracateg juracateg) {
	  getJuracategs().add(juracateg); juracateg.setCategoria(this);
	  
	  return juracateg; }
	  
	  public Juracateg removeJuracateg(Juracateg juracateg) {
	  getJuracategs().remove(juracateg); juracateg.setCategoria(null);
	  
	  return juracateg; }
	  
	  public List<Queso> getQuesos() { return this.quesos; }
	  
	  public void setQuesos(List<Queso> quesos) { this.quesos = quesos; }
	  
	  public Queso addQueso(Queso queso) { getQuesos().add(queso);
	  queso.setCategoria(this);
	  
	  return queso; }
	  
	  public Queso removeQueso(Queso queso) { getQuesos().remove(queso);
	  queso.setCategoria(null);
	  
	  return queso; }
	 
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}