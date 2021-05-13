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

import model.Evaluacione;
import model.Mesa;
import model.Mesajura;

@Named("mesa")
@ViewScoped
public class MesaWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "mesa/";
	private long idMesa;
	private String nombreMesa;
	private String ubicacion;
	private List<Evaluacione> evaluaciones;
	private List<Mesajura> mesajuras;
	private Mesa selectMesa;
	

	
	//Funciones GET
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public long getIdMesa() {
		return idMesa;
	}



	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}



	public String getNombreMesa() {
		return nombreMesa;
	}



	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}



	public String getUbicacion() {
		return ubicacion;
	}



	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



	public List<Evaluacione> getEvaluaciones() {
		return evaluaciones;
	}



	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}



	public List<Mesajura> getMesajuras() {
		return mesajuras;
	}



	public void setMesajuras(List<Mesajura> mesajuras) {
		this.mesajuras = mesajuras;
	}



	public Mesa getSelectMesa() {
		return selectMesa;
	}



	public void setSelectMesa(Mesa selectMesa) {
		this.selectMesa = selectMesa;
	}



	public List<Mesa> getMesas() {
		
		List<Mesa> listvar= new ArrayList<Mesa>();
		
		Gson gson = new Gson();
		Mesa[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Mesa[].class);
		for (Mesa m : listvr) {
			listvar.add(m);
		}
		return listvar;
	}
	
	
	//Funciones POST
	
	public String CrearMesa () {
		
		
		Mesa nueva= new Mesa();
		
		
		nueva.setEvaluaciones(null);
	    nueva.setMesajuras(null);
	    nueva.setNombreMesa(nombreMesa);
	    nueva.setUbicacion(ubicacion);
	    
	    
	    
		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);
		
		try {
			
			ConectABM.conectPost(json,rest+"crear");
			FacesMessage msg = new FacesMessage("Mesa creada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	    }
		return "Mesa.xhtml";
	}
	
	
	public String BorrarMesa (Mesa m) {
		System.out.print(m);
	
	
	Gson gson = new Gson();
	String json = gson.toJson(m);
	
	try {
		
		ConectABM.conectBorrar(json,rest+"borrar");
		FacesMessage msg = new FacesMessage("Mesa Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Mesa.xhtml";
	
	}
	
	public String ActualizarMesa (Mesa mesa) {
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(mesa);
		
		try {
			ConectABM.conectPut(json,rest+"update");
			Vaciar();
			FacesMessage msg = new FacesMessage("Mesa Modificada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Mesa.xhtml";
	}
	
	
		
		public void onRowSelect(SelectEvent<Mesa> event) {
			String s= String.valueOf(event.getObject().getIdMesa());
	        FacesMessage msg = new FacesMessage("Mesa Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Mesa> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdMesa()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	    public void onRowUnselect(UnselectEvent<Mesa> event) {
	    	String s= String.valueOf(event.getObject().getIdMesa());
	        FacesMessage msg = new FacesMessage("Mesa Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		public void Vaciar() {
		}
		
	     

}
