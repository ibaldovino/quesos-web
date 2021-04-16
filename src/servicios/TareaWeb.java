package servicios;

import java.io.IOException;
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


import model.Roltarea;
import model.Tarea;

@Named("tarea")
@ViewScoped
public class TareaWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "tarea/";
	Gson gson = new Gson();
	
	private long idTarea;
	private String descrTarea;
	private List<Roltarea> roltareas;
	private Tarea select;
	
	public Tarea getSelect() {
		return select;
	}

	public void setSelect(Tarea select) {
		this.select = select;
	}

	public long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public String getDescrTarea() {
		return descrTarea;
	}

	public void setDescrTarea(String descrTarea) {
		this.descrTarea = descrTarea;
	}

	public List<Roltarea> getRoltareas() {
		return roltareas;
	}

	public void setRoltareas(List<Roltarea> roltareas) {
		this.roltareas = roltareas;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}

	
	//Funciones GET
	
	public List<Tarea> getTareas() {
		
		List<Tarea> listtar= new ArrayList<Tarea>();
		
		Gson gson = new Gson();
		Tarea[] listta = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Tarea[].class);
		for (Tarea t : listta) {
			listtar.add(t);
		}
		return listtar;
	}
	
	
	
	//Funciones POST
	
		public String CrearTarea () {
			
			Tarea nueva= new Tarea();
			
			nueva.setDescrTarea(descrTarea);
			nueva.setRoltareas(roltareas);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Tarea Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Tarea.xhtml";
		}
		
		
		public String BorrarTarea (Tarea t) {
			System.out.print(t);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(t);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Tarea Eliminada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Tarea.xhtml";
		
		}
		
		public void ActualizarTarea (Tarea tar) {
			
	
			
			Gson gson = new Gson();
			String json = gson.toJson(tar);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				FacesMessage msg = new FacesMessage("Tarea Modificada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Tarea> event) {
			String s= String.valueOf(event.getObject().getIdTarea());
	        FacesMessage msg = new FacesMessage("Tarea Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Tarea> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdTarea()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Tarea> event) {
	    	String s= String.valueOf(event.getObject().getIdTarea());
	        FacesMessage msg = new FacesMessage("Tarea Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     

}
