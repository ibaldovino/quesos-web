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

import model.Departamento;
import model.Localidade;
import model.Participante;

@Named("localidade")
@ViewScoped
public class LocalidadWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	
	private String rest = ConectABM.urlServer() + "localidade/";
	private Localidade select;
	private long idLocal;
	private String descrLocal;
	private Departamento departamento;
	private List<Participante> participantes;
	private Gson gson = new Gson();
	
	private List<String> listDepa = new ArrayList<String>();
	private String depa;
	
	public List<String> getlistDepa() {

		listDepa = new ArrayList<String>();
		Departamento[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "departamento/todos"), Departamento[].class);
		for (Departamento s : list) {
			listDepa.add(s.getDescrDepto());
		}

		return listDepa;
	}
	
	
	

	// Funciones GET

	public String getDepa() {
		return depa;
	}

	public void setDepa(String depa) {
		this.depa = depa;
	}




	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Localidade getSelect() {
		return select;
	}

	public void setSelect(Localidade select) {
		this.select = select;
	}

	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

	public String getDescrLocal() {
		return descrLocal;
	}

	public void setDescrLocal(String descrLocal) {
		this.descrLocal = descrLocal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Localidade> getLocalidade() {

		List<Localidade> list = new ArrayList<Localidade>();

		Gson gson = new Gson();
		Localidade[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Localidade[].class);
		for (Localidade loc : lista) {
			list.add(loc);
		}
		return list;
	}

	// Funciones POST

	public String Crear () {
				
				
				Localidade nueva= new Localidade();
				nueva.setDepartamento(findDepartamento(depa));
				nueva.setDescrLocal(descrLocal);
				nueva.setParticipantes(null);
				
				
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Localidad creada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Localidad.xhtml";
			}

	public String Borrar(Localidade del) {
		System.out.print(del);

		Gson gson = new Gson();
		String json = gson.toJson(del);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Localidad Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Localidad.xhtml";

	}

	public void Actualizar(Localidade up) {

		Gson gson = new Gson();
		String json = gson.toJson(up);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Localidad Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent<Localidade> event) {
		String s = String.valueOf(event.getObject().getIdLocal());
		FacesMessage msg = new FacesMessage("Localidad Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Localidade> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdLocal()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Localidade> event) {
		String s = String.valueOf(event.getObject().getIdLocal());
		FacesMessage msg = new FacesMessage("Localidad Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public Departamento findDepartamento(String h) {

		Departamento obj = new Departamento();
		Departamento[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"departamento/todos"), Departamento[].class);
		for (Departamento e : list) {
			if (e.getDescrDepto().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

}