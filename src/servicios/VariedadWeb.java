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


import model.Queso;
import model.Variedad;

@Named("variedad")
@ViewScoped
public class VariedadWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/variedad/";
	private long IdVar;
	private String nombreVar;
	private String referencia;
	private Variedad selectVar;
	private List<Queso> quesos;
	Gson gson = new Gson();
	


	

	public List<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(List<Queso> quesos) {
		this.quesos = quesos;
	}

	public Variedad getSelectVar() {
		return selectVar;
	}

	public void setSelectVar(Variedad selectVar) {
		this.selectVar = selectVar;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public Long getIdVar() {
		return IdVar;
	}

	public void setIdVar(Long idVar) {
		IdVar = idVar;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}




	
	
	
	public String getNombreVar() {
		return nombreVar;
	}

	public void setNombreVar(String nombreVar) {
		this.nombreVar = nombreVar;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	
	//Funciones GET
	
	public List<Variedad> getVariedades() {
		
		List<Variedad> listvar= new ArrayList<Variedad>();
		
		Gson gson = new Gson();
		Variedad[] listvr = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Variedad[].class);
		for (Variedad v : listvr) {
			listvar.add(v);
		}
		return listvar;
	}
	
	
	
	//Funciones POST
	
		public String CrearVar () {
			
			Variedad nueva= new Variedad();
			
			
			nueva.setNombreVar(nombreVar);	
		    nueva.setReferencia(referencia);
		    nueva.setQuesos(null);
		    nueva.setIdVar(230);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crear");
				FacesMessage msg = new FacesMessage("Variedad Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Variedad.xhtml";
		}
		
		
		public String BorrarVar (Variedad v) {
			System.out.print(v);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(v);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Variedad Eliminada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Variedad.xhtml";
		
		}
		
		public void ActualizarVar (Variedad var) {
			
			//Subcatego nueva= new Subcatego();
			//nueva.setIdSubcateg(IdSubcateg);
			//nueva.setDescrip(Descrip);		
			//nueva.setIdentScat(IdentScat);
		    //nueva.setReferencia(Referencia);
			
			Gson gson = new Gson();
			String json = gson.toJson(var);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				Vaciar();
				FacesMessage msg = new FacesMessage("Variedad Modificada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Variedad> event) {
			String s= String.valueOf(event.getObject().getIdVar());
	        FacesMessage msg = new FacesMessage("Variedad Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Variedad> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdVar()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		
		
	    public void onRowUnselect(UnselectEvent<Variedad> event) {
	    	String s= String.valueOf(event.getObject().getIdVar());
	        FacesMessage msg = new FacesMessage("Variedad Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		public void Vaciar() {
			nombreVar= null;
			referencia= null;
		}
		
	     

}
