package servicios;


import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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

import model.Camara;
import model.Inscripcione;
@Named("camara")
@ViewScoped
public class CamaraWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/camara/";
	
	private long idCam;
	private String descCortaCam;
	private String descLargaCam;
	private String lugarCam;
	private BigDecimal nroCam;
	private BigDecimal temperaturaCam;
	private List<Inscripcione> inscripciones;
	private Camara select;
	

	public Camara getSelect() {
		return select;
	}

	public void setSelect(Camara select) {
		this.select = select;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}

	
	//Funciones GET
	
	public long getIdCam() {
		return idCam;
	}

	public void setIdCam(long idCam) {
		this.idCam = idCam;
	}

	public String getDescCortaCam() {
		return descCortaCam;
	}

	public void setDescCortaCam(String descCortaCam) {
		this.descCortaCam = descCortaCam;
	}

	public String getDescLargaCam() {
		return descLargaCam;
	}

	public void setDescLargaCam(String descLargaCam) {
		this.descLargaCam = descLargaCam;
	}

	public String getLugarCam() {
		return lugarCam;
	}

	public void setLugarCam(String lugarCam) {
		this.lugarCam = lugarCam;
	}

	public BigDecimal getNroCam() {
		return nroCam;
	}

	public void setNroCam(BigDecimal nroCam) {
		this.nroCam = nroCam;
	}

	public BigDecimal getTemperaturaCam() {
		return temperaturaCam;
	}

	public void setTemperaturaCam(BigDecimal temperaturaCam) {
		this.temperaturaCam = temperaturaCam;
	}

	public List<Inscripcione> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcione> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public List<Camara> getCamaras() {
		
		List<Camara> listcam= new ArrayList<Camara>();
		
		Gson gson = new Gson();
		Camara[] listcm = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Camara[].class);
		for (Camara c : listcm) {
			listcam.add(c);
		}
		return listcam;
	}
	
	//Funciones POST
	
	public String CrearCam () {
		
		
		Camara nueva= new Camara();
		
		
		nueva.setDescCortaCam(descCortaCam);
		nueva.setDescLargaCam(descLargaCam);
		nueva.setLugarCam(lugarCam);
		nueva.setInscripciones(null);
		nueva.setNroCam(nroCam);
		nueva.setTemperaturaCam(temperaturaCam);
		
	    
		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);
		
		try {
			
			ConectABM.conectPost(json,rest+"crear");
			FacesMessage msg = new FacesMessage("Cámara creada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        Vaciar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Camara.xhtml";
	}
	
	
	public String BorrarCam (Camara c) {
		System.out.print(c);
	
	
	Gson gson = new Gson();
	String json = gson.toJson(c);
	
	try {
		
		ConectABM.conectBorrar(json,rest+"borrar");
		FacesMessage msg = new FacesMessage("Cámara Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Camara.xhtml";
	
	}
	
	public void ActualizarCam (Camara cam) {
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(cam);
		
		try {
			ConectABM.conectPut(json,rest+"update");
			Vaciar();
			FacesMessage msg = new FacesMessage("Cámara Modificada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "SubCat.xhtml";
	}

	
	public void onRowSelect(SelectEvent<Camara> event) {
        FacesMessage msg = new FacesMessage("Camara Seleccionada", String.valueOf(event.getObject().getIdCam()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent<Camara> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdCam()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
    public void onRowUnselect(UnselectEvent<Camara> event) {
        FacesMessage msg = new FacesMessage("Camara Deseleccionada", String.valueOf(event.getObject().getIdCam()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
		
		
		public void Vaciar() {
			descCortaCam= null;
			descLargaCam= null;
			lugarCam= null;
			nroCam= null;
			temperaturaCam= null;
		}
		
	     

}
