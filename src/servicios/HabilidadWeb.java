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

@Named("habilidad")
@ViewScoped
public class HabilidadWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "habilidad/";
	private long idHabili;
	private String desHabildad;
	private List<Habijurado> habijurados;
	private Habilidade selectHabi;

	public long getIdHabili() {
		return idHabili;
	}

	public void setIdHabili(long idHabili) {
		this.idHabili = idHabili;
	}

	public String getDesHabildad() {
		return desHabildad;
	}

	public void setDesHabildad(String desHabildad) {
		this.desHabildad = desHabildad;
	}

	public List<Habijurado> getHabijurados() {
		return habijurados;
	}

	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}

	public Habilidade getSelectHabi() {
		return selectHabi;
	}

	public void setSelectHabi(Habilidade selectHabi) {
		this.selectHabi = selectHabi;
	}

	public List<Habilidade> getHabilidades() {

		List<Habilidade> listhab = new ArrayList<Habilidade>();

		Gson gson = new Gson();
		Habilidade[] listhb = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Habilidade[].class);
		for (Habilidade h : listhb) {
			listhab.add(h);
		}
		return listhab;
	}

	// Funciones POST

	public String Crear() {

		Habilidade nueva = new Habilidade();
		
		nueva.setIdHabili(idHabili);
		nueva.setDesHabildad(desHabildad);
		nueva.setHabijurados(null);
		

		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);

		try {

			ConectABM.conectPost(json, rest + "crear");
			FacesMessage msg = new FacesMessage("Habilidad Creada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			PrimeFaces.current().executeScript("PF('mostrar').hide()");
			PrimeFaces.current().ajax().update("form:HabiTabla");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return "Habilidad.xhtml";
	}

	public String Borrar(Habilidade h) {
		System.out.print(h);

		Gson gson = new Gson();
		String json = gson.toJson(h);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Habilidad Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Habilidad.xhtml";

	}

	public String Actualizar(Habilidade hab) {

		Gson gson = new Gson();
		String json = gson.toJson(hab);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Habilidad Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Habilidad.xhtml";
	}

	public void onRowSelect(SelectEvent<Habilidade> event) {
		String s = String.valueOf(event.getObject().getIdHabili());
		FacesMessage msg = new FacesMessage("Habilidad Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Habilidade> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdHabili()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Habilidade> event) {
		String s = String.valueOf(event.getObject().getIdHabili());
		FacesMessage msg = new FacesMessage("Habilidad Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
