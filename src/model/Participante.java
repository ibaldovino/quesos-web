package model;

import java.io.Serializable;
import java.util.List;



public class Participante implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idPart;

	private String apellidoPart;

	private String codPart;

	private String direccionPart;

	private String empresaPart;

	private String mailPart;

	private String nombrePart;

	private String rucPart;

	private String telefonoPart;

	private List<Inscripcione> inscripciones;

	private Localidade localidade;

	private Tipindustria tipindustria;

	public Participante() {
	}

	public long getIdPart() {
		return this.idPart;
	}

	public void setIdPart(long idPart) {
		this.idPart = idPart;
	}

	public String getApellidoPart() {
		return this.apellidoPart;
	}

	public void setApellidoPart(String apellidoPart) {
		this.apellidoPart = apellidoPart;
	}

	public String getCodPart() {
		return this.codPart;
	}

	public void setCodPart(String codPart) {
		this.codPart = codPart;
	}

	public String getDireccionPart() {
		return this.direccionPart;
	}

	public void setDireccionPart(String direccionPart) {
		this.direccionPart = direccionPart;
	}

	public String getEmpresaPart() {
		return this.empresaPart;
	}

	public void setEmpresaPart(String empresaPart) {
		this.empresaPart = empresaPart;
	}

	public String getMailPart() {
		return this.mailPart;
	}

	public void setMailPart(String mailPart) {
		this.mailPart = mailPart;
	}

	public String getNombrePart() {
		return this.nombrePart;
	}

	public void setNombrePart(String nombrePart) {
		this.nombrePart = nombrePart;
	}

	public String getRucPart() {
		return this.rucPart;
	}

	public void setRucPart(String rucPart) {
		this.rucPart = rucPart;
	}

	public String getTelefonoPart() {
		return this.telefonoPart;
	}

	public void setTelefonoPart(String telefonoPart) {
		this.telefonoPart = telefonoPart;
	}

	public List<Inscripcione> getInscripciones() {
		return this.inscripciones;
	}

	public void setInscripciones(List<Inscripcione> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Inscripcione addInscripcione(Inscripcione inscripcione) {
		getInscripciones().add(inscripcione);
		inscripcione.setParticipante(this);

		return inscripcione;
	}

	public Inscripcione removeInscripcione(Inscripcione inscripcione) {
		getInscripciones().remove(inscripcione);
		inscripcione.setParticipante(null);

		return inscripcione;
	}

	public Localidade getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Tipindustria getTipindustria() {
		return this.tipindustria;
	}

	public void setTipindustria(Tipindustria tipindustria) {
		this.tipindustria = tipindustria;
	}

}