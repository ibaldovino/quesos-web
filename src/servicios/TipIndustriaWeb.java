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

import model.Participante;

import model.Tipindustria;

@Named("tipindustria")
@ViewScoped
public class TipIndustriaWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;
	
	private String rest = ConectABM.urlServer() + "tipindustria/";
	Gson gson = new Gson();
	private long idTipind;
	private String descrTipind;
	private BigDecimal preInscPriQueso;
	private BigDecimal preInscSegQueso;
	private List<Participante> participantes;
	private Tipindustria select;
	

	
	

	

	
	//Funciones GET
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public long getIdTipind() {
		return idTipind;
	}



	public void setIdTipind(long idTipind) {
		this.idTipind = idTipind;
	}



	public String getDescrTipind() {
		return descrTipind;
	}



	public void setDescrTipind(String descrTipind) {
		this.descrTipind = descrTipind;
	}



	public BigDecimal getPreInscPriQueso() {
		return preInscPriQueso;
	}



	public void setPreInscPriQueso(BigDecimal preInscPriQueso) {
		this.preInscPriQueso = preInscPriQueso;
	}



	public BigDecimal getPreInscSegQueso() {
		return preInscSegQueso;
	}



	public void setPreInscSegQueso(BigDecimal preInscSegQueso) {
		this.preInscSegQueso = preInscSegQueso;
	}



	public List<Participante> getParticipantes() {
		return participantes;
	}



	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}



	public Tipindustria getSelect() {
		return select;
	}



	public void setSelect(Tipindustria select) {
		this.select = select;
	}



	public List<Tipindustria> getTipindus() {
		
		List<Tipindustria> list= new ArrayList<Tipindustria>();
		
		Gson gson = new Gson();
		Tipindustria[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Tipindustria[].class);
		for (Tipindustria ti : lista) {
			list.add(ti);
		}
		return list;
	}
	
	
	
	//Funciones POST
	
		public String Crear () {
			
			Tipindustria nueva= new Tipindustria();
			
			nueva.setDescrTipind(descrTipind);
			nueva.setParticipantes(null);
			nueva.setPreInscPriQueso(preInscPriQueso);
			nueva.setPreInscSegQueso(preInscSegQueso);
			
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Tipo Industria Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "TipoIndustria.xhtml";
		}
		
		
		public String Borrar (Tipindustria ti) {
			System.out.print(ti);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(ti);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Tipo Industria Eliminada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "TipoIndustria.xhtml";
		
		}
		
		public void Actualizar (Tipindustria var) {
			
			Gson gson = new Gson();
			String json = gson.toJson(var);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				FacesMessage msg = new FacesMessage("Tipo Industria Modificada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public void onRowSelect(SelectEvent<Tipindustria> event) {
			String s= String.valueOf(event.getObject().getIdTipind());
	        FacesMessage msg = new FacesMessage("Tipo Industria Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Tipindustria> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdTipind()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Tipindustria> event) {
	    	String s= String.valueOf(event.getObject().getIdTipind());
	        FacesMessage msg = new FacesMessage("Tipo Industria Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
	     

}
