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

import model.Habijurado;
import model.Habilidade;
import model.Jurado;
import model.Mesa;

@Named("habijurado")
@ViewScoped
public class HabiJuradoWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	
	private String rest = ConectABM.urlServer() + "habijurado/";
	private Habijurado select;
	private long idHabjur;
	private String observHabjur;
	private Habilidade habilidade;
	private Jurado jurado;
	
	private Gson gson = new Gson();
	
	private List<String> listJura = new ArrayList<String>();
	private String jura;
	
	public List<String> getlistJura() {

		listJura = new ArrayList<String>();
		Jurado[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "jurados/todos"), Jurado[].class);
		for (Jurado j : list) {
			listJura.add(j.getCedula().toString());
		}

		return listJura;
	}
	
	private List<String> listHabi = new ArrayList<String>();
	private String habi;
	
	public List<String> getlistHabi() {

		listHabi = new ArrayList<String>();
		Habilidade[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "habilidad/todas"), Habilidade[].class);
		for (Habilidade h : list) {
			listHabi.add(h.getDesHabildad());
		}

		return listHabi;
	}


	// Funciones GET
	
	

	public String getRest() {
		return rest;
	}

	public String getJura() {
		return jura;
	}


	public void setJura(String jura) {
		this.jura = jura;
	}


	public String getHabi() {
		return habi;
	}


	public void setHabi(String habi) {
		this.habi = habi;
	}


	public void setRest(String rest) {
		this.rest = rest;
	}

	public Habijurado getSelect() {
		return select;
	}

	public void setSelect(Habijurado select) {
		this.select = select;
	}

	public long getIdHabjur() {
		return idHabjur;
	}

	public void setIdHabjur(long idHabjur) {
		this.idHabjur = idHabjur;
	}

	public String getObservHabjur() {
		return observHabjur;
	}

	public void setObservHabjur(String observHabjur) {
		this.observHabjur = observHabjur;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public Jurado getJurado() {
		return jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public List<Habijurado> getHabijurado() {

		List<Habijurado> lista= new ArrayList<Habijurado>();

		Gson gson = new Gson();
		Habijurado[] list = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Habijurado[].class);
		for (Habijurado hj : list) {
			lista.add(hj);
		}
		return lista;
	}
	
	//Funciones POST
	
			public String Crear() {
				
				
				Habijurado nueva= new Habijurado();
				nueva.setHabilidade(findHabilidade(habi));
				nueva.setJurado(findJurado(jura));
				nueva.setObservHabjur(observHabjur);
				
			    
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Habilidad de Jurado creada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
			        PrimeFaces.current().executeScript("PF('mostrar').hide()");
			        PrimeFaces.current().ajax().update("form:HabiJuraTabla");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "HabiJurado.xhtml";
			}
			
			
			public String Borrar(Habijurado del) {
				System.out.print(del);
			
			
			Gson gson = new Gson();
			String json = gson.toJson(del);
			
			try {
				
				ConectABM.conectBorrar(json,rest+"borrar");
				FacesMessage msg = new FacesMessage("Habilidad de Jurado Eliminada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "HabiJurado.xhtml";
			
			}
			
			public void Actualizar(Habijurado up) {
				
				
				
				Gson gson = new Gson();
				String json = gson.toJson(up);
				
				try {
					ConectABM.conectPut(json,rest+"update");
					FacesMessage msg = new FacesMessage("Habilidad de Jurado Modificada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

	public void onRowSelect(SelectEvent<Habijurado> event) {
		String s = String.valueOf(event.getObject().getIdHabjur());
		FacesMessage msg = new FacesMessage("Habilidad de Jurado Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Habijurado> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdHabjur()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Habijurado> event) {
		String s = String.valueOf(event.getObject().getIdHabjur());
		FacesMessage msg = new FacesMessage("Habilidad de Jurado Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Jurado findJurado(String j) {

		Jurado obj = new Jurado();
		Jurado[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"jurados/todos"), Jurado[].class);
		for (Jurado e : list) {
			if (e.getCedula().toString().equals(j)) {
				obj = e;
			}
		}

		return obj;

	}
	
	public Habilidade findHabilidade(String m) {

		Habilidade obj = new Habilidade();
		Habilidade[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"habilidad/todas"), Habilidade[].class);
		for (Habilidade e : list) {
			if (e.getDesHabildad().equals(m)) {
				obj = e;
			}
		}

		return obj;

	}


}