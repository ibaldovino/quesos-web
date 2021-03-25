package model;

import java.io.Serializable;
import java.util.List;


public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long idDepto;

	
	private String descrDepto;

	
	private Pais pais;

	private List<Localidade> localidades;

	public Departamento() {
	}

	public long getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(long idDepto) {
		this.idDepto = idDepto;
	}

	public String getDescrDepto() {
		return this.descrDepto;
	}

	public void setDescrDepto(String descrDepto) {
		this.descrDepto = descrDepto;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Localidade> getLocalidades() {
		return this.localidades;
	}

	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}

	public Localidade addLocalidade(Localidade localidade) {
		getLocalidades().add(localidade);
		localidade.setDepartamento(this);

		return localidade;
	}

	public Localidade removeLocalidade(Localidade localidade) {
		getLocalidades().remove(localidade);
		localidade.setDepartamento(null);

		return localidade;
	}

}