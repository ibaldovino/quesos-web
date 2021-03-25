package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;



public class Evatipo implements Serializable {
	private static final long serialVersionUID = 1L;


	private long idEvatipo;


	private String descrTipeva;


	private BigDecimal ordenEval;


	private BigDecimal tipoeval;

	private List<Evadescrip> evadescrips;

	public Evatipo() {
	}

	public long getIdEvatipo() {
		return this.idEvatipo;
	}

	public void setIdEvatipo(long idEvatipo) {
		this.idEvatipo = idEvatipo;
	}

	public String getDescrTipeva() {
		return this.descrTipeva;
	}

	public void setDescrTipeva(String descrTipeva) {
		this.descrTipeva = descrTipeva;
	}

	public BigDecimal getOrdenEval() {
		return this.ordenEval;
	}

	public void setOrdenEval(BigDecimal ordenEval) {
		this.ordenEval = ordenEval;
	}

	public BigDecimal getTipoeval() {
		return this.tipoeval;
	}

	public void setTipoeval(BigDecimal tipoeval) {
		this.tipoeval = tipoeval;
	}

	public List<Evadescrip> getEvadescrips() {
		return this.evadescrips;
	}

	public void setEvadescrips(List<Evadescrip> evadescrips) {
		this.evadescrips = evadescrips;
	}

	public Evadescrip addEvadescrip(Evadescrip evadescrip) {
		getEvadescrips().add(evadescrip);
		evadescrip.setEvatipo(this);

		return evadescrip;
	}

	public Evadescrip removeEvadescrip(Evadescrip evadescrip) {
		getEvadescrips().remove(evadescrip);
		evadescrip.setEvatipo(null);

		return evadescrip;
	}

}