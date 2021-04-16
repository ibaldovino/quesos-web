package servicios;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.google.gson.Gson;

import model.Inscripcione;
import model.Localidade;
import model.Participante;
import model.Tipindustria;

@Named("participantes")
@ViewScoped
public class ParticipanteWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "participante/";
	private Participante select;
	private long idPart;
	private String apellidoPart;
	private String codPart;
	private String direccionPart;
	private String empresaPart;
	private String mailPart;
	private String nombrePart;
	private String rucPart;
	private String telefonoPart;
	private List<Inscripcione> inscripciones;
	private Localidade localidade;
	private Tipindustria tipindustria;

	// Funciones GET

	public String getRest() {
		return rest;
	}

	public String getNombrePart() {
		return nombrePart;
	}

	public void setNombrePart(String nombrePart) {
		this.nombrePart = nombrePart;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Participante getSelect() {
		return select;
	}

	public void setSelect(Participante select) {
		this.select = select;
	}

	public long getIdPart() {
		return idPart;
	}

	public void setIdPart(long idPart) {
		this.idPart = idPart;
	}

	public String getApellidoPart() {
		return apellidoPart;
	}

	public void setApellidoPart(String apellidoPart) {
		this.apellidoPart = apellidoPart;
	}

	public String getCodPart() {
		return codPart;
	}

	public void setCodPart(String codPart) {
		this.codPart = codPart;
	}

	public String getDireccionPart() {
		return direccionPart;
	}

	public void setDireccionPart(String direccionPart) {
		this.direccionPart = direccionPart;
	}

	public String getEmpresaPart() {
		return empresaPart;
	}

	public void setEmpresaPart(String empresaPart) {
		this.empresaPart = empresaPart;
	}

	public String getMailPart() {
		return mailPart;
	}

	public void setMailPart(String mailPart) {
		this.mailPart = mailPart;
	}

	public String getRucPart() {
		return rucPart;
	}

	public void setRucPart(String rucPart) {
		this.rucPart = rucPart;
	}

	public String getTelefonoPart() {
		return telefonoPart;
	}

	public void setTelefonoPart(String telefonoPart) {
		this.telefonoPart = telefonoPart;
	}

	public List<Inscripcione> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcione> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Tipindustria getTipindustria() {
		return tipindustria;
	}

	public void setTipindustria(Tipindustria tipindustria) {
		this.tipindustria = tipindustria;
	}

	public List<Participante> getParticipantes() {

		List<Participante> lista= new ArrayList<Participante>();

		Gson gson = new Gson();
		Participante[] list = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todos"), Participante[].class);
		for (Participante p : list) {
			lista.add(p);
		}
		return lista;
	}

	// Funciones POST

	public String Crear() {

		Participante nueva = new Participante();

		nueva.setApellidoPart(apellidoPart);
		nueva.setCodPart(codPart);
		nueva.setDireccionPart(direccionPart);
		nueva.setEmpresaPart(empresaPart);
		nueva.setInscripciones(inscripciones);
		nueva.setLocalidade(localidade);
		nueva.setMailPart(mailPart);
		nueva.setNombrePart(nombrePart);
		nueva.setRucPart(rucPart);
		nueva.setTelefonoPart(telefonoPart);
		nueva.setTipindustria(tipindustria);

		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);

		try {

			ConectABM.conectPost(json, rest + "crear");
			FacesMessage msg = new FacesMessage("Participante creado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Participante.xhtml";
	}

	public String Borrar(Participante p) {
		System.out.print(p);

		Gson gson = new Gson();
		String json = gson.toJson(p);

		try {

			ConectABM.conectBorrar(json, rest + "borrar");
			FacesMessage msg = new FacesMessage("Participante eliminado");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Participante.xhtml";

	}

	public void Actualizar(Participante par) {

		Gson gson = new Gson();
		String json = gson.toJson(par);

		try {
			ConectABM.conectPut(json, rest + "update");
			FacesMessage msg = new FacesMessage("Participante Modificado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "SubCat.xhtml";
	}

	public void onRowSelect(SelectEvent<Participante> event) {
		String s = String.valueOf(event.getObject().getIdPart());
		FacesMessage msg = new FacesMessage("Participante Seleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Participante> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdPart()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Participante> event) {
		String s = String.valueOf(event.getObject().getIdPart());
		FacesMessage msg = new FacesMessage("Participante Deseleccionado", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
