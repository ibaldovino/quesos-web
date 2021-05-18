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

import model.Categoria;
import model.Juracateg;
import model.Jurado;
import model.Categoria;
import model.Categoria;

@Named("juracateg")
@ViewScoped
public class JuraCategWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "juracateg/";
	private Juracateg select;
	private long idJurcat;
	private String observJurcat;
	private Categoria categoria;
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
	
	private List<String> listCat = new ArrayList<String>();
	private String categ;
	
	public List<String> getlistCat() {

		listCat = new ArrayList<String>();
		Categoria[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "categoria/todas"), Categoria[].class);
		for (Categoria p : list) {
			listCat.add(p.getDescrip());
		}

		return listCat;
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



	public String getCateg() {
		return categ;
	}



	public void setCateg(String categ) {
		this.categ = categ;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}

	public Juracateg getSelect() {
		return select;
	}

	public void setSelect(Juracateg select) {
		this.select = select;
	}

	public long getIdJurcat() {
		return idJurcat;
	}

	public void setIdJurcat(long idJurcat) {
		this.idJurcat = idJurcat;
	}

	public String getObservJurcat() {
		return observJurcat;
	}

	public void setObservJurcat(String observJurcat) {
		this.observJurcat = observJurcat;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Jurado getJurado() {
		return jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public List<Juracateg> getJuracateg() {

		List<Juracateg> list = new ArrayList<Juracateg>();

		Gson gson = new Gson();
		Juracateg[] lista = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Juracateg[].class);
		for (Juracateg jc : lista) {
			list.add(jc);
		}
		return list;
	}

	// Funciones POST

	public String Crear () {
				
				
				Juracateg nueva= new Juracateg();
				nueva.setCategoria(findCat(categ));
				nueva.setJurado(findJurado(jura));
				nueva.setObservJurcat(observJurcat);
				
			    
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Jurado Categoría creada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
			        PrimeFaces.current().executeScript("PF('mostrar').hide()");
			        PrimeFaces.current().ajax().update("form:JuraCatTabla");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "JuraCategoria.xhtml";
			}

	public String Borrar(Juracateg del) {
		System.out.print(del);

		Gson gson = new Gson();
		String json = gson.toJson(del);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Jurado Categoría Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "JuraCategoria.xhtml";

	}

	public void Actualizar(Juracateg up) {

		Gson gson = new Gson();
		String json = gson.toJson(up);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Jurado Categoría Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRowSelect(SelectEvent<Juracateg> event) {
		String s = String.valueOf(event.getObject().getIdJurcat());
		FacesMessage msg = new FacesMessage("Jurado Categoría Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Juracateg> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdJurcat()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Juracateg> event) {
		String s = String.valueOf(event.getObject().getIdJurcat());
		FacesMessage msg = new FacesMessage("Jurado Categoría Deseleccionada", s);
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
	
	public Categoria findCat(String m) {

		Categoria obj = new Categoria();
		Categoria[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"categoria/todas"), Categoria[].class);
		for (Categoria e : list) {
			if (e.getDescrip().equals(m)) {
				obj = e;
			}
		}

		return obj;

	}

}