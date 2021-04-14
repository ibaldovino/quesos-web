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

import model.Role;
import model.Roltarea;
import model.Tarea;
import model.Usuario;


@Named("roltarea")
@ViewScoped
public class RolTareaWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/roltarea/";
	private Roltarea select;
	private long idRoltar;
	private String autorizadoSn;
	private Role role;
	private Tarea tarea;
	
	
	

	// Funciones GET


	

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Roltarea getSelect() {
		return select;
	}

	public void setSelect(Roltarea select) {
		this.select = select;
	}

	public long getIdRoltar() {
		return idRoltar;
	}

	public void setIdRoltar(long idRoltar) {
		this.idRoltar = idRoltar;
	}

	public String getAutorizadoSn() {
		return autorizadoSn;
	}

	public void setAutorizadoSn(String autorizadoSn) {
		this.autorizadoSn = autorizadoSn;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public List<Roltarea> getRoltarea() {

		List<Roltarea> list = new ArrayList<Roltarea>();

		Gson gson = new Gson();
		Roltarea[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todos"), Roltarea[].class);
		for (Roltarea rol : lista) {
			list.add(rol);
		}
		return list;
	}

	// Funciones POST

	public String Crear () {
				
				
				Roltarea nueva= new Roltarea();
				nueva.setAutorizadoSn(autorizadoSn);
				nueva.setRole(role);
				nueva.setTarea(tarea);
				
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Rol Tarea Creado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Rol.xhtml";
			}

	public String Borrar(Roltarea del) {
		System.out.print(del);

		Gson gson = new Gson();
		String json = gson.toJson(del);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Rol Tarea Eliminado");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Rol.xhtml";

	}

	public void Actualizar(Roltarea up) {

		Gson gson = new Gson();
		String json = gson.toJson(up);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Rol Tarea Modificado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent<Roltarea> event) {
		String s = String.valueOf(event.getObject().getIdRoltar());
		FacesMessage msg = new FacesMessage("Rol Tarea Seleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Roltarea> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdRoltar()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Roltarea> event) {
		String s = String.valueOf(event.getObject().getIdRoltar());
		FacesMessage msg = new FacesMessage("Rol Tarea Deseleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}