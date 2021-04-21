package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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
	Gson gson = new Gson();
	private long idEvaluacion;
	private String fechaEval;
	private String horaEval;
	private String observacEvaluac;
	private String tipoPlanilla;
	private BigDecimal valorEvaluac;
	private Evadescrip evadescrip;
	private Jurado jurado;
	private Mesa mesa;
	private Queso queso;
	private Evaluacione select;
	
		

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

	public String getFechaEval() {
		return fechaEval;
	}

	public void setFechaEval(String fechaEval) {
		this.fechaEval = fechaEval;
	}

	public String getHoraEval() {
		return horaEval;
	}

	public void setHoraEval(String horaEval) {
		this.horaEval = horaEval;
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

		nueva.setEvadescrip(null);
		nueva.setFechaEval(fechaEval);
		nueva.setHoraEval(horaEval);
		nueva.setJurado(null);
		nueva.setMesa(null);
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


}
