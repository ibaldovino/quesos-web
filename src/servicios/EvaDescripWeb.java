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

import model.Evadescrip;
import model.Evaluacione;
import model.Evatipo;

@Named("evadescrip")
@ViewScoped
public class EvaDescripWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;


	private String rest = ConectABM.urlServer() + "evadescrip/";
	Gson gson = new Gson();
	private long idDescript;
	private String descrDescript;
	private Evatipo evatipo;
	private List<Evaluacione> evaluaciones;
	private Evadescrip select;
	
	

	// Funciones GET

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getIdDescript() {
		return idDescript;
	}

	public void setIdDescript(long idDescript) {
		this.idDescript = idDescript;
	}

	public String getDescrDescript() {
		return descrDescript;
	}

	public void setDescrDescript(String descrDescript) {
		this.descrDescript = descrDescript;
	}

	public Evatipo getEvatipo() {
		return evatipo;
	}

	public void setEvatipo(Evatipo evatipo) {
		this.evatipo = evatipo;
	}

	public List<Evaluacione> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Evadescrip getSelect() {
		return select;
	}

	public void setSelect(Evadescrip select) {
		this.select = select;
	}

	public List<Evadescrip> getEvadescrips() {

		List<Evadescrip> listvar = new ArrayList<Evadescrip>();

		Gson gson = new Gson();
		Evadescrip[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Evadescrip[].class);
		for (Evadescrip v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}

	// Funciones POST

	public String Crear() {

		Evadescrip nueva = new Evadescrip();

		nueva.setDescrDescript(descrDescript);
		nueva.setEvaluaciones(null);
		nueva.setEvatipo(null);

		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);

		try {

			ConectABM.conectPost(json, rest + "crear");
			FacesMessage msg = new FacesMessage("Evadescrip Creada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EvaDescriptores.xhtml";
	}

	public String Borrar(Evadescrip v) {
		System.out.print(v);

		Gson gson = new Gson();
		String json = gson.toJson(v);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Evadescrip Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EvaDescriptores.xhtml";

	}

	public void Actualizar(Evadescrip var) {

		

		Gson gson = new Gson();
		String json = gson.toJson(var);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Evadescrip Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onRowSelect(SelectEvent<Evadescrip> event) {
		String s = String.valueOf(event.getObject().getIdDescript());
		FacesMessage msg = new FacesMessage("Evadescrip Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Evadescrip> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdDescript()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Evadescrip> event) {
		String s = String.valueOf(event.getObject().getIdDescript());
		FacesMessage msg = new FacesMessage("Evadescrip Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


}
