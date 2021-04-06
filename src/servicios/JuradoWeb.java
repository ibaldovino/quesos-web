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

import model.Evaluacione;
import model.Habijurado;
import model.Juracateg;
import model.Jurado;
import model.Mesajura;

@Named("jurado")
@ViewScoped
public class JuradoWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "jurados/";
	
	private long idJurado;
	private String nombre;
	private String apellido;
	private BigDecimal cedula;
	private String direccion;
	private String email;	
	private String telefonoCel;
	private Jurado selectJurado;
	private List<Evaluacione> evaluaciones;
	private List<Habijurado> habijurados;
	private List<Juracateg> juracategs;
	private List<Mesajura> mesajuras;
	

	
	



	public Jurado getSelectJurado() {
		return selectJurado;
	}






	public void setSelectJurado(Jurado selectJurado) {
		this.selectJurado = selectJurado;
	}






	public long getIdJurado() {
		return idJurado;
	}






	public void setIdJurado(long idJurado) {
		this.idJurado = idJurado;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getApellido() {
		return apellido;
	}






	public void setApellido(String apellido) {
		this.apellido = apellido;
	}






	public BigDecimal getCedula() {
		return cedula;
	}






	public void setCedula(BigDecimal cedula) {
		this.cedula = cedula;
	}






	public String getDireccion() {
		return direccion;
	}






	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getTelefonoCel() {
		return telefonoCel;
	}






	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}






	public List<Evaluacione> getEvaluaciones() {
		return evaluaciones;
	}






	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}






	public List<Habijurado> getHabijurados() {
		return habijurados;
	}






	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}






	public List<Juracateg> getJuracategs() {
		return juracategs;
	}






	public void setJuracategs(List<Juracateg> juracategs) {
		this.juracategs = juracategs;
	}






	public List<Mesajura> getMesajuras() {
		return mesajuras;
	}






	public void setMesajuras(List<Mesajura> mesajuras) {
		this.mesajuras = mesajuras;
	}






	public List<Jurado> getJurados() {
		
		List<Jurado> listjur= new ArrayList<Jurado>();
		
		Gson gson = new Gson();
		Jurado[] listjr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Jurado[].class);
		for (Jurado j : listjr) {
			listjur.add(j);
		}
		return listjur;
	}
	
	
	
	//Funciones POST
	
			public String CrearJur () {
				
				Jurado nueva= new Jurado();
				
				nueva.setIdJurado(180);
				nueva.setApellido(apellido);
				nueva.setCedula(cedula);
				nueva.setDireccion(direccion);
				nueva.setEmail(email);
				nueva.setEvaluaciones(null);
				nueva.setHabijurados(null);
				nueva.setJuracategs(null);
				nueva.setMesajuras(null);
				nueva.setNombre(nombre);
				nueva.setTelefonoCel(telefonoCel);
			    
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Jurado Creado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        return "Jurados.xhtml";
			}
			
			
			public String BorrarJur (Jurado j) {
				System.out.print(j);
			
			
			Gson gson = new Gson();
			String json = gson.toJson(j);
			
			try {
				
				ConectABM.conectBorrar(json,rest+"borrar");
				FacesMessage msg = new FacesMessage("Jurado Eliminado");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Jurados.xhtml";
			
			}
			
			public String ActualizarJur (Jurado jur) {
				
				Gson gson = new Gson();
				String json = gson.toJson(jur);
				
				try {
					ConectABM.conectPut(json,rest+"update");
					Vaciar();
					FacesMessage msg = new FacesMessage("Jurado Modificado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Jurados.xhtml";
			}
	
		
		public void onRowSelect(SelectEvent<Jurado> event) {
			String s= String.valueOf(event.getObject().getIdJurado());
	        FacesMessage msg = new FacesMessage("Jurado Seleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Jurado> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdJurado()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
	    public void onRowUnselect(UnselectEvent<Jurado> event) {
	    	String s= String.valueOf(event.getObject().getIdJurado());
	        FacesMessage msg = new FacesMessage("Jurado Deseleccionado", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		public void Vaciar() {
		}
		
	     


}
