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

import model.Queso;
import model.Tipoleche;

@Named("tipleche")
@ViewScoped
public class TipLecheWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "tipoleche/";
	Gson gson = new Gson();
	
	private long idTiplec;
	private String nombre;
	private String referencia;
	private List<Queso> quesos;
	private Tipoleche select;
	
	
	
	//Funciones GET
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public long getIdTiplec() {
		return idTiplec;
	}



	public void setIdTiplec(long idTiplec) {
		this.idTiplec = idTiplec;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public List<Queso> getQuesos() {
		return quesos;
	}



	public void setQuesos(List<Queso> quesos) {
		this.quesos = quesos;
	}



	public Tipoleche getSelect() {
		return select;
	}



	public void setSelect(Tipoleche select) {
		this.select = select;
	}



	public List<Tipoleche> getTiposLeche() {
		
		List<Tipoleche> listvar= new ArrayList<Tipoleche>();
		
		Gson gson = new Gson();
		Tipoleche[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Tipoleche[].class);
		for (Tipoleche v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}
	
	
	
	//Funciones POST
	
		public String Crear () {
			
			Tipoleche nueva= new Tipoleche();
			
			nueva.setNombre(nombre);
			nueva.setQuesos(quesos);
			nueva.setReferencia(referencia);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Tipoleche Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "TipoLeche.xhtml";
		}
		
		
		public String Borrar (Tipoleche v) {
			System.out.print(v);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(v);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Tipo Leche Eliminado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "TipoLeche.xhtml";
		
		}
		
		public void Actualizar (Tipoleche var) {
			
	
			
			Gson gson = new Gson();
			String json = gson.toJson(var);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				FacesMessage msg = new FacesMessage("Tipo Leche Modificado");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Tipoleche> event) {
			String s= String.valueOf(event.getObject().getIdTiplec());
	        FacesMessage msg = new FacesMessage("Tipo Leche Seleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Tipoleche> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdTiplec()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Tipoleche> event) {
	    	String s= String.valueOf(event.getObject().getIdTiplec());
	        FacesMessage msg = new FacesMessage("Tipo Leche Deseleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
	     

}
