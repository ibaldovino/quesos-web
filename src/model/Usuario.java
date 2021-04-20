package model;

import java.io.Serializable;



public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idUsuario;
	
	private String apeUsuario;

	private String fecaltUsuario;

	private String fecbajUsuario;

	private String fecsusUsuario;

	private String mailUsuario;

	private String nomUsuario;

	private String pwdUsuario;

	private String telefUsuario;

	private String usuario;


	private Estusuario estusuario;


	private Role role;

	public Usuario() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApeUsuario() {
		return this.apeUsuario;
	}

	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}

	public String getFecaltUsuario() {
		return this.fecaltUsuario;
	}

	public void setFecaltUsuario(String fecaltUsuario) {
		this.fecaltUsuario = fecaltUsuario;
	}

	public String getFecbajUsuario() {
		return this.fecbajUsuario;
	}

	public void setFecbajUsuario(String fecbajUsuario) {
		this.fecbajUsuario = fecbajUsuario;
	}

	public String getFecsusUsuario() {
		return this.fecsusUsuario;
	}

	public void setFecsusUsuario(String fecsusUsuario) {
		this.fecsusUsuario = fecsusUsuario;
	}

	public String getMailUsuario() {
		return this.mailUsuario;
	}

	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}

	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPwdUsuario() {
		return this.pwdUsuario;
	}

	public void setPwdUsuario(String pwdUsuario) {
		this.pwdUsuario = pwdUsuario;
	}

	public String getTelefUsuario() {
		return this.telefUsuario;
	}

	public void setTelefUsuario(String telefUsuario) {
		this.telefUsuario = telefUsuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Estusuario getEstusuario() {
		return this.estusuario;
	}

	public void setEstusuario(Estusuario estusuario) {
		this.estusuario = estusuario;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}