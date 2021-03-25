package model;

import java.io.Serializable;
import java.util.List;



public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idLocal;

	private String descrLocal;

	private Departamento departamento;

	private List<Participante> participantes;

	public Localidade() {
	}

	public long getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

	public String getDescrLocal() {
		return this.descrLocal;
	}

	public void setDescrLocal(String descrLocal) {
		this.descrLocal = descrLocal;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setLocalidade(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setLocalidade(null);

		return participante;
	}

}