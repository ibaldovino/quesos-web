package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;



public class Camara implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long idCam;

	
	private String descCortaCam;

	
	private String descLargaCam;

	
	private String lugarCam;

	
	private BigDecimal nroCam;

	
	private BigDecimal temperaturaCam;

		
	private List<Inscripcione> inscripciones;

	public Camara() {
	}

	public long getIdCam() {
		return this.idCam;
	}

	public void setIdCam(long idCam) {
		this.idCam = idCam;
	}

	public String getDescCortaCam() {
		return this.descCortaCam;
	}

	public void setDescCortaCam(String descCortaCam) {
		this.descCortaCam = descCortaCam;
	}

	public String getDescLargaCam() {
		return this.descLargaCam;
	}

	public void setDescLargaCam(String descLargaCam) {
		this.descLargaCam = descLargaCam;
	}

	public String getLugarCam() {
		return this.lugarCam;
	}

	public void setLugarCam(String lugarCam) {
		this.lugarCam = lugarCam;
	}

	public BigDecimal getNroCam() {
		return this.nroCam;
	}

	public void setNroCam(BigDecimal nroCam) {
		this.nroCam = nroCam;
	}

	public BigDecimal getTemperaturaCam() {
		return this.temperaturaCam;
	}

	public void setTemperaturaCam(BigDecimal temperaturaCam) {
		this.temperaturaCam = temperaturaCam;
	}

	public List<Inscripcione> getInscripciones() {
		return this.inscripciones;
	}

	public void setInscripciones(List<Inscripcione> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Inscripcione addInscripcione(Inscripcione inscripcione) {
		getInscripciones().add(inscripcione);
		inscripcione.setCamara(this);

		return inscripcione;
	}

	public Inscripcione removeInscripcione(Inscripcione inscripcione) {
		getInscripciones().remove(inscripcione);
		inscripcione.setCamara(null);

		return inscripcione;
	}

}