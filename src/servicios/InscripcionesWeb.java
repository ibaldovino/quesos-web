package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.google.gson.Gson;

import model.Camara;
import model.Inscripcione;
import model.Participante;
import model.Queso;

@Named("inscripcione")
@ViewScoped
public class InscripcionesWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;


	private String rest = ConectABM.urlServer() + "inscripcione/";
	private Inscripcione select;
	private long idInsc;
	private Date fechaCte;
	private Date fechaInsc;
	private BigDecimal nroCte;
	private String observInscrip;
	private String otros;
	private String serieCte;
	private BigDecimal valorCte;
	private Camara camara;
	private Participante participante;
	private Queso queso;


	// Funciones GET

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Inscripcione getSelect() {
		return select;
	}

	public void setSelect(Inscripcione select) {
		this.select = select;
	}

	public long getIdInsc() {
		return idInsc;
	}

	public void setIdInsc(long idInsc) {
		this.idInsc = idInsc;
	}

	public Date getFechaCte() {
		return fechaCte;
	}

	public void setFechaCte(Date fechaCte) {
		this.fechaCte = fechaCte;
	}

	public Date getFechaInsc() {
		return fechaInsc;
	}

	public void setFechaInsc(Date fechaInsc) {
		this.fechaInsc = fechaInsc;
	}


	public BigDecimal getNroCte() {
		return nroCte;
	}

	public void setNroCte(BigDecimal nroCte) {
		this.nroCte = nroCte;
	}

	public String getObservInscrip() {
		return observInscrip;
	}

	public void setObservInscrip(String observInscrip) {
		this.observInscrip = observInscrip;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getSerieCte() {
		return serieCte;
	}

	public void setSerieCte(String serieCte) {
		this.serieCte = serieCte;
	}

	public BigDecimal getValorCte() {
		return valorCte;
	}

	public void setValorCte(BigDecimal valorCte) {
		this.valorCte = valorCte;
	}

	public Camara getCamara() {
		return camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Queso getQueso() {
		return queso;
	}

	public void setQueso(Queso queso) {
		this.queso = queso;
	}

	public List<Inscripcione> getInscripcione() {

		List<Inscripcione> lista = new ArrayList<Inscripcione>();

		Gson gson = new Gson();
		Inscripcione[] list = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Inscripcione[].class);
		for (Inscripcione ins: list) {
			lista.add(ins);
		}
		return lista;
	}
	
	//Funciones POST
	
			public String Crear() {
				
				
				Inscripcione nueva= new Inscripcione();
				
				nueva.setCamara(camara);
				nueva.setFechaCte(fechaCte);
				nueva.setFechaInsc(fechaInsc);
				//nueva.setHoraInsc(horaInsc);
				nueva.setNroCte(nroCte);
				nueva.setObservInscrip(observInscrip);
				nueva.setOtros(otros);
				nueva.setParticipante(participante);
				nueva.setQueso(queso);
				nueva.setSerieCte(serieCte);
				nueva.setValorCte(valorCte);
				
			    
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Maduración creada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Inscripcione.xhtml";
			}
			
			
			public String Borrar(Inscripcione del) {
				System.out.print(del);
			
			
			Gson gson = new Gson();
			String json = gson.toJson(del);
			
			try {
				
				ConectABM.conectBorrar(json,rest+"borrar");
				FacesMessage msg = new FacesMessage("Inscripcione Eliminada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Inscripciones.xhtml";
			
			}
			
			public void Actualizar(Inscripcione up) {
				
				
				
				Gson gson = new Gson();
				String json = gson.toJson(up);
				
				try {
					ConectABM.conectPut(json,rest+"update");
					FacesMessage msg = new FacesMessage("Inscripcion Modificada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//return "SubCat.xhtml";
			}

	public void onRowSelect(SelectEvent<Inscripcione> event) {
		String s = String.valueOf(event.getObject().getIdInsc());
		FacesMessage msg = new FacesMessage("Inscripcion Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Inscripcione> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdInsc()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Inscripcione> event) {
		String s = String.valueOf(event.getObject().getIdInsc());
		FacesMessage msg = new FacesMessage("Inscripcion Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	

}