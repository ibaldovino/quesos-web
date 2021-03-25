package model;

import java.io.Serializable;
import java.util.List;


public class Estusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String idEstadoUsuario;

	
	private String descrEstado;

	
	private List<Usuario> usuarios;

	public Estusuario() {
	}

	public String getIdEstadoUsuario() {
		return this.idEstadoUsuario;
	}

	public void setIdEstadoUsuario(String idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}

	public String getDescrEstado() {
		return this.descrEstado;
	}

	public void setDescrEstado(String descrEstado) {
		this.descrEstado = descrEstado;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEstusuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEstusuario(null);

		return usuario;
	}

}