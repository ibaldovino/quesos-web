package model;

import java.io.Serializable;
import java.util.List;


public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	private long idTarea;

	private String descrTarea;

	private List<Roltarea> roltareas;

	public Tarea() {
	}

	public long getIdTarea() {
		return this.idTarea;
	}

	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	public String getDescrTarea() {
		return this.descrTarea;
	}

	public void setDescrTarea(String descrTarea) {
		this.descrTarea = descrTarea;
	}

	public List<Roltarea> getRoltareas() {
		return this.roltareas;
	}

	public void setRoltareas(List<Roltarea> roltareas) {
		this.roltareas = roltareas;
	}

	public Roltarea addRoltarea(Roltarea roltarea) {
		getRoltareas().add(roltarea);
		roltarea.setTarea(this);

		return roltarea;
	}

	public Roltarea removeRoltarea(Roltarea roltarea) {
		getRoltareas().remove(roltarea);
		roltarea.setTarea(null);

		return roltarea;
	}

}