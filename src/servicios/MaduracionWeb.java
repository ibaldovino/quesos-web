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

import model.Maduracion;
import model.Queso;

@Named("maduracion")
@ViewScoped
public class MaduracionWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/maduracion/";
	private long idMadur;
	private String descrip;
	private String referencia;
	private List<Queso> quesos;
	private Maduracion select;

	public long getIdMadur() {
		return idMadur;
	}

	public void setIdMadur(long idMadur) {
		this.idMadur = idMadur;
	}

	public Maduracion getSelect() {
		return select;
	}

	public void setSelect(Maduracion select) {
		this.select = select;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(List<Queso> quesos) {
		this.quesos = quesos;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}

	// Funciones GET

	public List<Maduracion> getMaduracion() {

		List<Maduracion> listMad = new ArrayList<Maduracion>();

		Gson gson = new Gson();
		Maduracion[] listMd = gson.fromJson(ReadJson.readJsonFromUrl(rest + "todas"), Maduracion[].class);
		for (Maduracion m : listMd) {
			listMad.add(m);
		}
		return listMad;
	}
	
	//Funciones POST
	
			public String CrearMad () {
				
				
				Maduracion nueva= new Maduracion();
				
				//nueva.setIdSubcateg(523);
				nueva.setDescrip(descrip);		
				//nueva.setIdMadur(180);
			    nueva.setReferencia(referencia);
			    nueva.setQuesos(null);
			    
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
				return "Maduracion.xhtml";
			}
			
			
			public String BorrarMad (Maduracion m) {
				System.out.print(m);
			
			
			Gson gson = new Gson();
			String json = gson.toJson(m);
			
			try {
				
				ConectABM.conectBorrar(json,rest+"borrar");
				FacesMessage msg = new FacesMessage("Maduracion Eliminada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Maduracion.xhtml";
			
			}
			
			public void ActualizarMad (Maduracion mad) {
				
				
				
				Gson gson = new Gson();
				String json = gson.toJson(mad);
				
				try {
					ConectABM.conectPut(json,rest+"update");
					Vaciar();
					FacesMessage msg = new FacesMessage("Maduracion Modificada");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//return "SubCat.xhtml";
			}

	public void onRowSelect(SelectEvent<Maduracion> event) {
		String s = String.valueOf(event.getObject().getIdMadur());
		FacesMessage msg = new FacesMessage("Maduracion Seleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Maduracion> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdMadur()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent<Maduracion> event) {
		String s = String.valueOf(event.getObject().getIdMadur());
		FacesMessage msg = new FacesMessage("Maduracion Deseleccionada", s);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void Vaciar() {
		descrip = null;
		referencia = null;
	}

}