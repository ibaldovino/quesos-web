package model;

import java.io.Serializable;



public class Roltarea implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idRoltar;

	private String autorizadoSn;

	private Role role;

	private Tarea tarea;

	public Roltarea() {
	}

	public long getIdRoltar() {
		return this.idRoltar;
	}

	public void setIdRoltar(long idRoltar) {
		this.idRoltar = idRoltar;
	}

	public String getAutorizadoSn() {
		return this.autorizadoSn;
	}

	public void setAutorizadoSn(String autorizadoSn) {
		this.autorizadoSn = autorizadoSn;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

}