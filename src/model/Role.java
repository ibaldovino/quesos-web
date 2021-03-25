package model;

import java.io.Serializable;
import java.util.List;


public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idRol;

	private String descrRol;

	private List<Roltarea> roltareas;

	private List<Usuario> usuarios;

	public Role() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getDescrRol() {
		return this.descrRol;
	}

	public void setDescrRol(String descrRol) {
		this.descrRol = descrRol;
	}

	public List<Roltarea> getRoltareas() {
		return this.roltareas;
	}

	public void setRoltareas(List<Roltarea> roltareas) {
		this.roltareas = roltareas;
	}

	public Roltarea addRoltarea(Roltarea roltarea) {
		getRoltareas().add(roltarea);
		roltarea.setRole(this);

		return roltarea;
	}

	public Roltarea removeRoltarea(Roltarea roltarea) {
		getRoltareas().remove(roltarea);
		roltarea.setRole(null);

		return roltarea;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRole(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRole(null);

		return usuario;
	}

}