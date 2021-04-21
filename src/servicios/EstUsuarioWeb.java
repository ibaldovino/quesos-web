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

import model.Estusuario;
import model.Usuario;

@Named("estadoUsu")
@ViewScoped
public class EstUsuarioWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;
	
	private String rest = ConectABM.urlServer() + "estusuario/";
	Gson gson = new Gson();
	private String idEstadoUsuario;
	private String descrEstado;
	private List<Usuario> usuarios;
	private Estusuario select;

	 

	
	//Funciones GET
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public String getIdEstadoUsuario() {
		return idEstadoUsuario;
	}



	public void setIdEstadoUsuario(String idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}



	public String getDescrEstado() {
		return descrEstado;
	}



	public void setDescrEstado(String descrEstado) {
		this.descrEstado = descrEstado;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public Estusuario getSelect() {
		return select;
	}



	public void setSelect(Estusuario select) {
		this.select = select;
	}



	public List<Estusuario> getEstusuarios() {
		
		List<Estusuario> listvar= new ArrayList<Estusuario>();
		
		Gson gson = new Gson();
		Estusuario[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Estusuario[].class);
		for (Estusuario v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}
	
	
	
	//Funciones POST
	
		public String Crear() {
			
			Estusuario nueva= new Estusuario();
			
			nueva.setIdEstadoUsuario(idEstadoUsuario);
			nueva.setDescrEstado(descrEstado);
			nueva.setUsuarios(null);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Estado Usuario Creado");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "EstadoUsu.xhtml";
		}
		
		
		public String Borrar(Estusuario v) {
			System.out.print(v);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(v);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Estado Usuario Eliminado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EstadoUsu.xhtml";
		
		}
		
		public void Actualizar(Estusuario var) {
			
			
			
			Gson gson = new Gson();
			String json = gson.toJson(var);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				FacesMessage msg = new FacesMessage("Estado Usuario Modificado");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Estusuario> event) {
			String s= String.valueOf(event.getObject().getIdEstadoUsuario());
	        FacesMessage msg = new FacesMessage("Estado Usuario Seleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Estusuario> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdEstadoUsuario()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Estusuario> event) {
	    	String s= String.valueOf(event.getObject().getIdEstadoUsuario());
	        FacesMessage msg = new FacesMessage("Estado Usuario Deseleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		
		
	     

}
