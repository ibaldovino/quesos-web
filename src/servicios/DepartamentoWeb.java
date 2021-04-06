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
import model.Localidade;
import model.Pais;
@Named("departamento")
@ViewScoped
public class DepartamentoWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "departamento/";
	
	private long idDepto;
	private String descrDepto;
	private Pais pais;
	private List<Localidade> localidades;
	private Departamento select;
	

	//Funciones GET
	
	
	public String getRest() {
		return rest;
	}

	public List<Localidade> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public long getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(long idDepto) {
		this.idDepto = idDepto;
	}

	public String getDescrDepto() {
		return descrDepto;
	}

	public void setDescrDepto(String descrDepto) {
		this.descrDepto = descrDepto;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Departamento getSelect() {
		return select;
	}

	public void setSelect(Departamento select) {
		this.select = select;
	}

	public List<Departamento> getDepartamentos() {
		
		List<Departamento> listdep= new ArrayList<Departamento>();
		
		Gson gson = new Gson();
		Departamento[] listdp = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Departamento[].class);
		for (Departamento p : listdp) {
			listdep.add(p);
		}
		return listdep;
	}
	
	//Funciones POST
	
	public String CrearDep () {
		
		
		Departamento nuevo= new Departamento();
		
		
		nuevo.setDescrDepto(descrDepto);
		nuevo.setPais(null);
		nuevo.setLocalidades(null);
		
	    
		System.out.println(nuevo);
		Gson gson = new Gson();
		String json = gson.toJson(nuevo);
		
		try {
			
			ConectABM.conectPost(json,rest+"crear");
			FacesMessage msg = new FacesMessage("Departamento creado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Departamento.xhtml";
	}
	
	
	public String BorrarDep (Departamento d) {
		System.out.print(d);
	
	
	Gson gson = new Gson();
	String json = gson.toJson(d);
	
	try {
		
		ConectABM.conectBorrar(json,rest+"borrar");
		FacesMessage msg = new FacesMessage("Departamento Eliminado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Departamento.xhtml";
	
	}
	
	public void ActualizarCam (Departamento dep) {
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(dep);
		
		try {
			ConectABM.conectPut(json,rest+"update");
			FacesMessage msg = new FacesMessage("Departamento Modificado");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "SubCat.xhtml";
	}

	
	public void onRowSelect(SelectEvent<Departamento> event) {
        FacesMessage msg = new FacesMessage("Departamento Seleccionado", String.valueOf(event.getObject().getIdDepto()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent<Departamento> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdDepto()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
    public void onRowUnselect(UnselectEvent<Departamento> event) {
        FacesMessage msg = new FacesMessage("Departamento Deseleccionado", String.valueOf(event.getObject().getIdDepto()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
		
	     

}
