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
import model.Tecnologia;

@Named("tecnologia")
@ViewScoped
public class TecnologiaWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/tecnologias/";
	private long idTecno;
	private String descrip;
	private String referencia;
	private List<Queso> quesos;
	private Tecnologia select;


	public Tecnologia getSelect() {
		return select;
	}


	public void setSelect(Tecnologia select) {
		this.select = select;
	}


	public long getIdTecno() {
		return idTecno;
	}


	public void setIdTecno(long idTecno) {
		this.idTecno = idTecno;
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

	

	

	
	//Funciones GET
	
	public List<Tecnologia> getTecnologias() {
		
		List<Tecnologia> listtec= new ArrayList<Tecnologia>();
		
		Gson gson = new Gson();
		Tecnologia[] listTc = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Tecnologia[].class);
		for (Tecnologia v : listTc) {
			listtec.add(v);
		}
		return listtec;
	}
	
	
	//Funciones POST
	
	public String CrearTec() {
		
		
		Tecnologia nueva= new Tecnologia();
		
		nueva.setDescrip(descrip);
		nueva.setReferencia(referencia);
		nueva.setQuesos(null);
	    
		System.out.println(nueva);
		Gson gson = new Gson();
		String json = gson.toJson(nueva);
		
		try {
			
			ConectABM.conectPost(json,rest+"crear");
			FacesMessage msg = new FacesMessage("Tecnología creada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Tecnologia.xhtml";
	}
	
	
	public String BorrarTec(Tecnologia t) {
			
	Gson gson = new Gson();
	String json = gson.toJson(t);
	
	System.out.println(json);
	
	try {
		
		ConectABM.conectBorrar(json,rest+"borrar");
		FacesMessage msg = new FacesMessage("Tecnologia Eliminada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Tecnologia.xhtml";
	
	}
	
	public void ActualizarTec(Tecnologia tec) {
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(tec);
		
		try {
			ConectABM.conectPut(json,rest+"update");
			Vaciar();
			FacesMessage msg = new FacesMessage("Tecnologia Modificada");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "SubCat.xhtml";
	}
	
	
		
		public void onRowSelect(SelectEvent<Tecnologia> event) {
			String s= String.valueOf(event.getObject().getIdTecno());
	        FacesMessage msg = new FacesMessage("Tecnología Seleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		public void onRowCancel(RowEditEvent<Tecnologia> event) {
			FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdTecno()));
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
	    public void onRowUnselect(UnselectEvent<Tecnologia> event) {
	    	String s= String.valueOf(event.getObject().getIdTecno());
	        FacesMessage msg = new FacesMessage("Tecnología Deseleccionada", s);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }	
		
		
		public void Vaciar() {
			descrip= null;
			referencia= null;
		}
		
	     

}
