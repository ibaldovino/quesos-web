package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.google.gson.Gson;

import model.Evadescrip;
import model.Evatipo;

@Named("evatipo")
@ViewScoped
public class EvaTipoWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "evatipo/";
	Gson gson = new Gson();
	private long idEvatipo;
	private String descrTipeva;
	private BigDecimal ordenEval;
	private BigDecimal tipoeval;
	private List<Evadescrip> evadescrips;
	private Evatipo select;
		

	//Funciones GET
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public long getIdEvatipo() {
		return idEvatipo;
	}



	public void setIdEvatipo(long idEvatipo) {
		this.idEvatipo = idEvatipo;
	}



	public String getDescrTipeva() {
		return descrTipeva;
	}



	public void setDescrTipeva(String descrTipeva) {
		this.descrTipeva = descrTipeva;
	}



	public BigDecimal getOrdenEval() {
		return ordenEval;
	}



	public void setOrdenEval(BigDecimal ordenEval) {
		this.ordenEval = ordenEval;
	}



	public BigDecimal getTipoeval() {
		return tipoeval;
	}



	public void setTipoeval(BigDecimal tipoeval) {
		this.tipoeval = tipoeval;
	}



	public List<Evadescrip> getEvadescrips() {
		return evadescrips;
	}



	public void setEvadescrips(List<Evadescrip> evadescrips) {
		this.evadescrips = evadescrips;
	}



	public Evatipo getSelect() {
		return select;
	}



	public void setSelect(Evatipo select) {
		this.select = select;
	}



	public List<Evatipo> getEvatipoes() {
		
		List<Evatipo> listvar= new ArrayList<Evatipo>();
		
		Gson gson = new Gson();
		Evatipo[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Evatipo[].class);
		for (Evatipo v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}
	
	
	
	//Funciones POST
	
		public String Crear () {
			
			Evatipo nueva= new Evatipo();
			
			
			nueva.setDescrTipeva(descrTipeva);
			nueva.setEvadescrips(evadescrips);
			nueva.setOrdenEval(ordenEval);
			nueva.setTipoeval(tipoeval);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Evatipo Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Evatipo.xhtml";
		}
		
		
		public String Borrar (Evatipo v) {
			System.out.print(v);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(v);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Evatipo Eliminada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Evatipo.xhtml";
		
		}
		
		public void Actualizar (Evatipo var) {
			
					
			Gson gson = new Gson();
			String json = gson.toJson(var);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				FacesMessage msg = new FacesMessage("Evatipo Modificada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Evatipo> event) {
			String s= String.valueOf(event.getObject().getIdEvatipo());
	        FacesMessage msg = new FacesMessage("Evatipo Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Evatipo> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdEvatipo()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Evatipo> event) {
	    	String s= String.valueOf(event.getObject().getIdEvatipo());
	        FacesMessage msg = new FacesMessage("Evatipo Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
	     

}
