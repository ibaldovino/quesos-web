package model;

import java.io.Serializable;
import java.util.List;


public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idPais;

	private String descrPais;

	private List<Departamento> departamentos;

	public Pais() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getDescrPais() {
		return this.descrPais;
	}

	public void setDescrPais(String descrPais) {
		this.descrPais = descrPais;
	}

	public List<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento addDepartamento(Departamento departamento) {
		getDepartamentos().add(departamento);
		departamento.setPais(this);

		return departamento;
	}

	public Departamento removeDepartamento(Departamento departamento) {
		getDepartamentos().remove(departamento);
		departamento.setPais(null);

		return departamento;
	}

}