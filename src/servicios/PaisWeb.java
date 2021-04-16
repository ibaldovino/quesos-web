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


import model.Departamento;
import model.Pais;
@Named("pais")
@ViewScoped
public class PaisWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	
	private String rest = ConectABM.urlServer() + "paises/";
	
	private long idPais;
	private String descrPais;
	private List<Departamento> departamentos;
	private Pais select;
	

	

	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getIdPais() {
		return idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getDescrPais() {
		return descrPais;
	}

	public void setDescrPais(String descrPais) {
		this.descrPais = descrPais;
	}

	public Pais getSelect() {
		return select;
	}

	public void setSelect(Pais select) {
		this.select = select;
	}

	

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public List<Pais> getPaises() {
		
		List<Pais> listpais= new ArrayList<Pais>();
		
		Gson gson = new Gson();
		Pais[] listps= gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Pais[].class);
		for (Pais p : listps) {
			listpais.add(p);
		}
		return listpais;
	}
	
	//Funciones POST
	
	public String CrearPais () {
		
		
		Pais nuevo= new Pais();
		
		nuevo.setIdPais(15);
		nuevo.setDepartamentos(null);
		nuevo.setDescrPais(descrPais);
		
	    
		System.out.println(nuevo);
		Gson gson = new Gson();
		String json = gson.toJson(nuevo);
		
		try {
			
			ConectABM.conectPost(json,rest+"crear");
			FacesMessage msg = new FacesMessage("País creado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Pais.xhtml";
	}
	
	
	public String BorrarPais (Pais p) {
		System.out.print(p);
	
	
	Gson gson = new Gson();
	String json = gson.toJson(p);
	
	try {
		
		ConectABM.conectBorrar(json,rest+"borrar");
		FacesMessage msg = new FacesMessage("País Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Pais.xhtml";
	
	}
	
	public void ActualizarPais (Pais pa) {
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(pa);
		
		try {
			ConectABM.conectPut(json,rest+"update");
			FacesMessage msg = new FacesMessage("País Modificado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "SubCat.xhtml";
	}

	
	public void onRowSelect(SelectEvent<Pais> event) {
        FacesMessage msg = new FacesMessage("Pais Seleccionado", String.valueOf(event.getObject().getIdPais()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent<Pais> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdPais()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
    public void onRowUnselect(UnselectEvent<Pais> event) {
        FacesMessage msg = new FacesMessage("Pais Deseleccionado", String.valueOf(event.getObject().getIdPais()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
		
	     

}