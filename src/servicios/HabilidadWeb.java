package servicios;

import java.io.Serializable;
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


import model.Habijurado;
import model.Habilidade;

@Named("habilidad")
@ViewScoped
public class HabilidadWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/habilidad/";
	private long idHabili;
	private String desHabildad;
	private List<Habijurado> habijurados;
	private Habilidade selectHabi;
	


	public long getIdHabili() {
		return idHabili;
	}






	public void setIdHabili(long idHabili) {
		this.idHabili = idHabili;
	}






	public String getDesHabildad() {
		return desHabildad;
	}






	public void setDesHabildad(String desHabildad) {
		this.desHabildad = desHabildad;
	}






	public List<Habijurado> getHabijurados() {
		return habijurados;
	}






	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}






	public Habilidade getSelectHabi() {
		return selectHabi;
	}






	public void setSelectHabi(Habilidade selectHabi) {
		this.selectHabi = selectHabi;
	}






	public List<Habilidade> getHabilidades() {
		
		List<Habilidade> listhab= new ArrayList<Habilidade>();
		
		Gson gson = new Gson();
		Habilidade[] listhb = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Habilidade[].class);
		for (Habilidade h : listhb) {
			listhab.add(h);
		}
		return listhab;
	}
	
	
	
	
	
		
		public void onRowSelect(SelectEvent<Habilidade> event) {
			String s= String.valueOf(event.getObject().getIdHabili());
	        FacesMessage msg = new FacesMessage("Habilidad Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Habilidade> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdHabili()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	    public void onRowUnselect(UnselectEvent<Habilidade> event) {
	    	String s= String.valueOf(event.getObject().getIdHabili());
	        FacesMessage msg = new FacesMessage("Habilidad Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		public void Vaciar() {
		}
		
	     


}
