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



import model.Jurado;
import model.Mesa;
import model.Mesajura;

@Named("mesajura")
@ViewScoped
public class MesaJuraWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "mesajura/";
	private Mesajura select;
	private long idMesjur;
	private String funcion;
	private String observMesjur;
	private Jurado jurado;
	private Mesa mesa;
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
	
	private List<String> listMesa = new ArrayList<String>();
	private String mes;
	
	public List<String> getlistMesa() {

		listMesa = new ArrayList<String>();
		Mesa[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "mesa/todas"), Mesa[].class);
		for (Mesa p : list) {
			listMesa.add(p.getNombreMesa());
		}

		return listMesa;
	}

	

	// Funciones GET
	

	public String getJura() {
		return jura;
	}



	public void setJura(String jura) {
		this.jura = jura;
	}



	public String getMes() {
		return mes;
	}



	public void setMes(String mes) {
		this.mes = mes;
	}


	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Mesajura getSelect() {
		return select;
	}

	public void setSelect(Mesajura select) {
		this.select = select;
	}

	public long getIdMesjur() {
		return idMesjur;
	}

	public void setIdMesjur(long idMesjur) {
		this.idMesjur = idMesjur;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getObservMesjur() {
		return observMesjur;
	}

	public void setObservMesjur(String observMesjur) {
		this.observMesjur = observMesjur;
	}

	public Jurado getJurado() {
		return jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<Mesajura> getMesajura() {

		List<Mesajura> list = new ArrayList<Mesajura>();

		Gson gson = new Gson();
		Mesajura[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Mesajura[].class);
		for (Mesajura mj : lista) {
			list.add(mj);
		}
		return list;
	}

	// Funciones POST

	public String Crear () {
				
				
				Mesajura nueva= new Mesajura();
				nueva.setFuncion(funcion);
				nueva.setJurado(findJurado(jura));
				nueva.setMesa(findMesa(mes));
				nueva.setObservMesjur(observMesjur);
				
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Mesa Jura creada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
			        PrimeFaces.current().executeScript("PF('mostrar').hide()");
			        PrimeFaces.current().ajax().update("form:MesaJuraTabla");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "MesaJura.xhtml";
			}

	public String Borrar(Mesajura del) {
		System.out.print(del);

		Gson gson = new Gson();
		String json = gson.toJson(del);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Mesa Jura Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MesaJura.xhtml";

	}

	public void Actualizar(Mesajura up) {

		Gson gson = new Gson();
		String json = gson.toJson(up);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Mesa Jura Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent<Mesajura> event) {
		String s = String.valueOf(event.getObject().getIdMesjur());
		FacesMessage msg = new FacesMessage("Mesa Jura Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Mesajura> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdMesjur()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Mesajura> event) {
		String s = String.valueOf(event.getObject().getIdMesjur());
		FacesMessage msg = new FacesMessage("Mesa Jura Deseleccionada", s);
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
	
	public Mesa findMesa(String m) {

		Mesa obj = new Mesa();
		Mesa[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"mesa/todas"), Mesa[].class);
		for (Mesa e : list) {
			if (e.getNombreMesa().equals(m)) {
				obj = e;
			}
		}

		return obj;

	}

}