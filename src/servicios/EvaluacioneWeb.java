package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

import model.Evadescrip;
import model.Evaluacione;
import model.Jurado;
import model.Mesa;
import model.Queso;

@Named("evaluacione")
@ViewScoped
public class EvaluacioneWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;


	private String rest = ConectABM.urlServer() + "evaluacione/";
	private Gson gson = new Gson();
	private long idEvaluacion;
	private Date fechaEval;
	private String observacEvaluac;
	private String tipoPlanilla;
	private BigDecimal valorEvaluac;
	private Evadescrip evadescrip;
	private Jurado jurado;
	private Mesa mesa;
	private Queso queso;
	private Evaluacione select;
	
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
	
	private List<String> listQueso = new ArrayList<String>();
	private String quesoS;
	
	public List<String> getlistQueso() {

		listQueso = new ArrayList<String>();
		Queso[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "quesos/todos"), Queso[].class);
		for (Queso q : list) {
			listQueso.add(q.getCodigoAuto());
		}

		return listQueso;
	}
	
	private List<String> listEvaDes = new ArrayList<String>();
	private String evaD;
	
	public List<String> getlistEvaDes() {

		listEvaDes = new ArrayList<String>();
		Evadescrip[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() + "evadescrip/todas"), Evadescrip[].class);
		for (Evadescrip ed : list) {
			listEvaDes.add(ed.getDescrDescript());
		}

		return listEvaDes;
	}
	


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


	public String getQuesoS() {
		return quesoS;
	}


	public void setQuesoS(String quesoS) {
		this.quesoS = quesoS;
	}



	public String getEvaD() {
		return evaD;
	}


	public void setEvaD(String evaD) {
		this.evaD = evaD;
	}



	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Date getFechaEval() {
		return fechaEval;
	}

	public void setFechaEval(Date fechaEval) {
		this.fechaEval = fechaEval;
	}


	public String getObservacEvaluac() {
		return observacEvaluac;
	}

	public void setObservacEvaluac(String observacEvaluac) {
		this.observacEvaluac = observacEvaluac;
	}

	public String getTipoPlanilla() {
		return tipoPlanilla;
	}

	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	public BigDecimal getValorEvaluac() {
		return valorEvaluac;
	}

	public void setValorEvaluac(BigDecimal valorEvaluac) {
		this.valorEvaluac = valorEvaluac;
	}

	
	public Evadescrip getEvadescrip() {
		return evadescrip;
	}

	public void setEvadescrip(Evadescrip evadescrip) {
		this.evadescrip = evadescrip;
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

	public Queso getQueso() {
		return queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

	public Evaluacione getSelect() {
		return select;
	}

	public void setSelect(Evaluacione select) {
		this.select = select;
	}

	public List<Evaluacione> getEvaluaciones() {

		List<Evaluacione> listvar = new ArrayList<Evaluacione>();

		Gson gson = new Gson();
		Evaluacione[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Evaluacione[].class);
		for (Evaluacione v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}

	// Funciones POST

	public String Crear() {

		Evaluacione nueva = new Evaluacione();
		
		System.out.println(fechaEval);

		nueva.setEvadescrip(findEvaD(evaD));
		nueva.setFechaEval(null);
		nueva.setJurado(findJurado(jura));
		nueva.setMesa(findMesa(mes));
		nueva.setObservacEvaluac(observacEvaluac);
		nueva.setQueso(null);
		nueva.setTipoPlanilla(tipoPlanilla);
		nueva.setValorEvaluac(valorEvaluac);

		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);

		try {

			ConectABM.conectPost(json, rest + "crear");
			FacesMessage msg = new FacesMessage("Evaluacion Creada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			PrimeFaces.current().executeScript("PF('mostrar').hide()");
	        PrimeFaces.current().ajax().update("form:EvaTabla");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "Evaluacion.xhtml";
	}

	public String Borrar(Evaluacione v) {
		System.out.print(v);

		Gson gson = new Gson();
		String json = gson.toJson(v);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Evaluacion Eliminada");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Evaluacion.xhtml";

	}

	public void Actualizar(Evaluacione var) {

		

		Gson gson = new Gson();
		String json = gson.toJson(var);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Evaluacion Modificada");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "SubCat.xhtml";
	}

	public void onRowSelect(SelectEvent<Evaluacione> event) {
		String s = String.valueOf(event.getObject().getIdEvaluacion());
		FacesMessage msg = new FacesMessage("Evaluacion Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Evaluacione> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdEvaluacion()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Evaluacione> event) {
		String s = String.valueOf(event.getObject().getIdEvaluacion());
		FacesMessage msg = new FacesMessage("Evaluacion Deseleccionada", s);
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
	
	public Queso findQueso(String q) {

		Queso obj = new Queso();
		Queso[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"quesos/todos"), Queso[].class);
		for (Queso e : list) {
			if (e.getCodigoAuto().equals(q)) {
				obj = e;
			}
		}

		return obj;

	}
	
	public Evadescrip findEvaD(String ed) {

		Evadescrip obj = new Evadescrip();
		Evadescrip[] list = gson.fromJson(ReadJson.readJsonFromUrl(ConectABM.urlServer() +"evadescrip/todas"), Evadescrip[].class);
		for (Evadescrip e : list) {
			if (e.getDescrDescript().equals(ed)) {
				obj = e;
			}
		}

		return obj;

	}


}
