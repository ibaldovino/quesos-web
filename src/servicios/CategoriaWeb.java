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

import model.Catego;
import model.Categoria;
import model.Juracateg;
import model.Queso;

@Named("categ")
@ViewScoped
public class CategoriaWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8530010742002535090L;
	
	private String descrip;
	private String identCateg;
	private String referencia;
	private List<Juracateg> juracategs; 
	private List<Queso> listquesos;
	private List<Categoria> listcateg;
	private Gson gson = new Gson();
	private String rest = ConectABM.urlServer();
	private Categoria select;
	
	
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getIdentCateg() {
		return identCateg;
	}
	public void setIdentCateg(String identCateg) {
		this.identCateg = identCateg;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public Categoria getSelect() {
		return select;
	}
	public void setSelect(Categoria select) {
		this.select = select;
	}
	
	public List<Categoria> getListcateg(){
		listcateg = new ArrayList<Categoria>();
		Categoria[] lcateg = gson.fromJson(ReadJson.readJsonFromUrl(rest+"categoria/todas"), Categoria[].class);
		for (Categoria q : lcateg) {
			listcateg.add(q);
		}
		return listcateg;
		
	}
	
	public List<Juracateg> getJuracategs() {
		juracategs = new ArrayList<Juracateg>();
		Juracateg[] ljuracategs = gson.fromJson(ReadJson.readJsonFromUrl(rest+"quesos/todos"), Juracateg[].class);
		for (Juracateg q : ljuracategs) {
			juracategs.add(q);
		}
		return juracategs;
	}
	
	public void setJuracategs(List<Juracateg> juracategs) {
		this.juracategs = juracategs;
	}
	
		
	public List<Queso> getListquesos() {
		listquesos = new ArrayList<Queso>();
		Queso[] quesos = gson.fromJson(ReadJson.readJsonFromUrl(rest+"quesos/todos"), Queso[].class);
		for (Queso q : quesos) {
			listquesos.add(q);
		}
		return listquesos;
	}
	public void setListquesos(List<Queso> listquesos) {
		this.listquesos = listquesos;
	}
	public void onEdit(RowEditEvent<Categoria> event) {
		FacesMessage msg = new FacesMessage("Queso Editado", event.getObject().getIdentCateg());
		select = event.getObject();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowSelect(SelectEvent<Categoria> event) {
		FacesMessage msg = new FacesMessage("Queso Seleccionado", event.getObject().getIdentCateg());
		//select = event.getObject();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCancel(RowEditEvent<Categoria> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", event.getObject().getIdentCateg());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowUnselect(UnselectEvent<Categoria> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", event.getObject().getIdentCateg());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public String BorrarCa(Categoria s) {
		
		String json = gson.toJson(s);

		try {

			ConectABM.conectBorrar(json, rest + "categoria/borrar");
			FacesMessage msg = new FacesMessage("Categoria Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Categoria.xhtml";

	}
	
	public String CrearCA() {

		Catego ca = new Catego();

		ca.setDescrip(descrip);
		ca.setIdentCateg(identCateg);
		ca.setReferencia(referencia);

		
		String json = gson.toJson(ca);
		System.out.println(json);

		try {

			ConectABM.conectPost(json, rest + "categoria/crear");
			FacesMessage msg = new FacesMessage("Categoria Creada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Categoria.xhtml";
	}
	
	

}
