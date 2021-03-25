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

import model.Humedad;
import model.Queso;
import model.Subcatego;

@Named("humedad")
@ViewScoped
public class HumedadWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/hum/";
	private List<Queso> quesos;
	private long idHumed;
	private String Descrip;
	private String Referencia;
	private Humedad selectHumed;

	public Humedad getSelectHumed() {
		return selectHumed;
	}

	public void setSelectHumed(Humedad selectHumed) {
		this.selectHumed = selectHumed;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getIdHumed() {
		return idHumed;
	}

	public void setIdHumed(long idHumed) {
		this.idHumed = idHumed;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}

	public List<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(List<Queso> quesos) {
		this.quesos = quesos;
	}

	public String getDescrip() {
		return Descrip;
	}

	public void setDescrip(String descrip) {
		Descrip = descrip;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	// Funciones GET

	public List<Humedad> getHumedades() {

		List<Humedad> listhum = new ArrayList<Humedad>();

		Gson gson = new Gson();
		Humedad[] listhm = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Humedad[].class);
		for (Humedad h : listhm) {
			listhum.add(h);
		}
		return listhum;
	}

	// Funciones POST

	public String CrearHum() {

		Subcatego nueva = new Subcatego();

		// nueva.setIdSubcateg(523);
		nueva.setDescrip(Descrip);
		nueva.setReferencia(Referencia);

		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);

		try {

			ConectABM.conectPost(json, rest + "crear");
			FacesMessage msg = new FacesMessage("Humedad Creada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Humedad.xhtml";
	}

	public String Borrar(Humedad h) {
		System.out.print(h);

		Gson gson = new Gson();
		String json = gson.toJson(h);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Humedad Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Humedad.xhtml";
	}

	public void ActualizarHum(Humedad h) {

		// Subcatego nueva= new Subcatego();
		// nueva.setIdSubcateg(IdSubcateg);
		// nueva.setDescrip(Descrip);
		// nueva.setIdentScat(IdentScat);
		// nueva.setReferencia(Referencia);

		Gson gson = new Gson();
		String json = gson.toJson(h);

		try {
			ConectABM.conectPut(json, rest + "update");
			Vaciar();
			FacesMessage msg = new FacesMessage("Humedad Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "SubCat.xhtml";
	}

	public void onRowSelect(SelectEvent<Humedad> event) {
		String s = String.valueOf(event.getObject().getIdHumed());
		FacesMessage msg = new FacesMessage("Humedad Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Humedad> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdHumed()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Humedad> event) {
		String s = String.valueOf(event.getObject().getIdHumed());
		FacesMessage msg = new FacesMessage("Humedad Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void Vaciar() {
		Descrip = null;
		Referencia = null;
	}

}
