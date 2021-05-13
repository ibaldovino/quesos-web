package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Evaluacione implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idEvaluacion;


	private Date fechaEval;

	
	private String observacEvaluac;

	
	private String tipoPlanilla;

	
	private BigDecimal valorEvaluac;

	
	private Evadescrip evadescrip;

	
	private Jurado jurado;


	private Mesa mesa;

	private Queso queso;

	public Evaluacione() {
	}

	public long getIdEvaluacion() {
		return this.idEvaluacion;
	}

	public void setIdEvaluacion(long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Date getFechaEval() {
		return this.fechaEval;
	}

	public void setFechaEval(Date fechaEval) {
		this.fechaEval = fechaEval;
	}


	public String getObservacEvaluac() {
		return this.observacEvaluac;
	}

	public void setObservacEvaluac(String observacEvaluac) {
		this.observacEvaluac = observacEvaluac;
	}

	public String getTipoPlanilla() {
		return this.tipoPlanilla;
	}

	public void setTipoPlanilla(String tipoPlanilla) {
		this.tipoPlanilla = tipoPlanilla;
	}

	public BigDecimal getValorEvaluac() {
		return this.valorEvaluac;
	}

	public void setValorEvaluac(BigDecimal valorEvaluac) {
		this.valorEvaluac = valorEvaluac;
	}

	public Evadescrip getEvadescrip() {
		return this.evadescrip;
	}

	public void setEvadescrip(Evadescrip evadescrip) {
		this.evadescrip = evadescrip;
	}

	public Jurado getJurado() {
		return this.jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Queso getQueso() {
		return this.queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

}