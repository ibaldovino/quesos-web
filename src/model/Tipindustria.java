package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class Tipindustria implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idTipind;

	private String descrTipind;

	private BigDecimal preInscPriQueso;

	private BigDecimal preInscSegQueso;

	private List<Participante> participantes;

	public Tipindustria() {
	}

	public long getIdTipind() {
		return this.idTipind;
	}

	public void setIdTipind(long idTipind) {
		this.idTipind = idTipind;
	}

	public String getDescrTipind() {
		return this.descrTipind;
	}

	public void setDescrTipind(String descrTipind) {
		this.descrTipind = descrTipind;
	}

	public BigDecimal getPreInscPriQueso() {
		return this.preInscPriQueso;
	}

	public void setPreInscPriQueso(BigDecimal preInscPriQueso) {
		this.preInscPriQueso = preInscPriQueso;
	}

	public BigDecimal getPreInscSegQueso() {
		return this.preInscSegQueso;
	}

	public void setPreInscSegQueso(BigDecimal preInscSegQueso) {
		this.preInscSegQueso = preInscSegQueso;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setTipindustria(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setTipindustria(null);

		return participante;
	}

}