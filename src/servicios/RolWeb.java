package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.google.gson.Gson;



import model.Role;
import model.Roltarea;
import model.Usuario;


@Named("role")
@ViewScoped
public class RolWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "role/";
	private Role select;
	private long idRol;
	private String descrRol;
	private List<Roltarea> roltareas;
	private List<Usuario> usuarios;
	
	

	// Funciones GET


	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Role getSelect() {
		return select;
	}

	public void setSelect(Role select) {
		this.select = select;
	}

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDescrRol() {
		return descrRol;
	}

	public void setDescrRol(String descrRol) {
		this.descrRol = descrRol;
	}

	public List<Roltarea> getRoltareas() {
		return roltareas;
	}

	public void setRoltareas(List<Roltarea> roltareas) {
		this.roltareas = roltareas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Role> getRole() {

		List<Role> list = new ArrayList<Role>();

		Gson gson = new Gson();
		Role[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todos"), Role[].class);
		for (Role rol : lista) {
			list.add(rol);
		}
		return list;
	}

	// Funciones POST

	public String Crear () {
				
				
				Role nueva= new Role();
				nueva.setDescrRol(descrRol);
				nueva.setRoltareas(null);
				nueva.setUsuarios(null);
				
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Rol Creado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
			        PrimeFaces.current().executeScript("PF('mostrar').hide()");
			        PrimeFaces.current().ajax().update("form:JuradoTabla");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Rol.xhtml";
			}

	public String Borrar(Role del) {
		System.out.print(del);

		Gson gson = new Gson();
		String json = gson.toJson(del);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Rol Eliminado");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Rol.xhtml";

	}

	public void Actualizar(Role up) {

		Gson gson = new Gson();
		String json = gson.toJson(up);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Rol Modificado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent<Role> event) {
		String s = String.valueOf(event.getObject().getIdRol());
		FacesMessage msg = new FacesMessage("Rol Seleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Role> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdRol()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Role> event) {
		String s = String.valueOf(event.getObject().getIdRol());
		FacesMessage msg = new FacesMessage("Rol Deseleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}