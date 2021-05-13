package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Inscripcione implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idInsc;


	private Date fechaCte;


	private Date fechaInsc;


	private BigDecimal nroCte;


	private String observInscrip;

	private String otros;

	private String serieCte;


	private BigDecimal valorCte;


	private Camara camara;


	private Participante participante;

	private Queso queso;

	public Inscripcione() {
	}

	public long getIdInsc() {
		return this.idInsc;
	}

	public void setIdInsc(long idInsc) {
		this.idInsc = idInsc;
	}

	public Date getFechaCte() {
		return this.fechaCte;
	}

	public void setFechaCte(Date fechaCte) {
		this.fechaCte = fechaCte;
	}

	public Date getFechaInsc() {
		return this.fechaInsc;
	}

	public void setFechaInsc(Date fechaInsc) {
		this.fechaInsc = fechaInsc;
	}


	public BigDecimal getNroCte() {
		return this.nroCte;
	}

	public void setNroCte(BigDecimal nroCte) {
		this.nroCte = nroCte;
	}

	public String getObservInscrip() {
		return this.observInscrip;
	}

	public void setObservInscrip(String observInscrip) {
		this.observInscrip = observInscrip;
	}

	public String getOtros() {
		return this.otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getSerieCte() {
		return this.serieCte;
	}

	public void setSerieCte(String serieCte) {
		this.serieCte = serieCte;
	}

	public BigDecimal getValorCte() {
		return this.valorCte;
	}

	public void setValorCte(BigDecimal valorCte) {
		this.valorCte = valorCte;
	}

	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

	public Participante getParticipante() {
		return this.participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Queso getQueso() {
		return this.queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

}