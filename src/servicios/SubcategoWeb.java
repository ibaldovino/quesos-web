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
import model.Subcatego;

@Named("subcat")
@ViewScoped
public class SubcategoWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/subcat/";
	private List<Subcatego> listsubc;
	private Long IdSubcateg;
	private String Descrip;
	private String IdentScat;
	private String Referencia;
	private Subcatego selectSubcat;
	
	

	public Subcatego getSelectSubcat() {
		return selectSubcat;
	}

	public void setSelectSubcat(Subcatego selectSubcat) {
		this.selectSubcat = selectSubcat;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	public void setIdSubcateg(Long idSubcateg) {
		IdSubcateg = idSubcateg;
	}

	public String getRest() {
		return rest;
	}

	public void setRest1(String rest) {
		this.rest = rest;
	}

	public List<Subcatego> getListsubc() {
		return listsubc;
	}

	public void setListsubc(List<Subcatego> listsubc) {
		this.listsubc = listsubc;
	}

	public Long getIdSubcateg() {
		return IdSubcateg;
	}

	public void setIdSubcategoria(Long idSubcateg) {
		IdSubcateg = idSubcateg;
	}

	public String getDescrip() {
		return Descrip;
	}

	public void setDescrip(String descrip) {
		Descrip = descrip;
	}

	public String getIdentScat() {
		return IdentScat;
	}

	public void setIdentScat(String identScat) {
		IdentScat = identScat;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	
	//Funciones GET
	
	public List<Subcatego> getSubcatego() {
		
		List<Subcatego> listsub = new ArrayList<Subcatego>();
		
		Gson gson = new Gson();
		Subcatego[] listsb = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Subcatego[].class);
		for (Subcatego s : listsb) {
			listsub.add(s);
		}
		return listsub;
	}
	
	
	
	//Funciones POST
	
		public String CrearSB () {
			
			Subcatego nueva= new Subcatego();
			
			//nueva.setIdSubcateg(523);
			nueva.setDescrip(Descrip);		
			nueva.setIdentScat(IdentScat);
		    nueva.setReferencia(Referencia);
		    
			System.out.println(nueva);
			Gson gson = new Gson();
			String json = gson.toJson(nueva);
			
			try {
				
				ConectABM.conectPost(json,rest+"crearsc");
				FacesMessage msg = new FacesMessage("Subcategoria Creada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        return "SubCat.xhtml";
		}
		
		
		public String BorrarSB (Subcatego s) {
			System.out.print(s);
		
		
		Gson gson = new Gson();
		String json = gson.toJson(s);
		
		try {
			
			ConectABM.conectBorrar(json,rest+"borrar");
			FacesMessage msg = new FacesMessage("Subcategoria Eliminada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SubCat.xhtml";
		
		}
		
		public String ActualizarSC (Subcatego sub) {
			
			//Subcatego nueva= new Subcatego();
			//nueva.setIdSubcateg(IdSubcateg);
			//nueva.setDescrip(Descrip);		
			//nueva.setIdentScat(IdentScat);
		    //nueva.setReferencia(Referencia);
			
			Gson gson = new Gson();
			String json = gson.toJson(sub);
			
			try {
				ConectABM.conectPut(json,rest+"update");
				Vaciar();
				FacesMessage msg = new FacesMessage("Subcategoria Modificada");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "SubCat.xhtml";
		}
		
		public void onRowSelect(SelectEvent<Subcatego> event) {
	        FacesMessage msg = new FacesMessage("SubCategoria Seleccionada", event.getObject().getIdentScat());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Subcatego> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdentScat()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	    public void onRowUnselect(UnselectEvent<Subcatego> event) {
	        FacesMessage msg = new FacesMessage("SubCategoria Deseleccionada", event.getObject().getIdentScat());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		
		public void Vaciar() {
			Descrip= null;
			IdentScat= null;
			Referencia= null;
		}
		
	     

}
