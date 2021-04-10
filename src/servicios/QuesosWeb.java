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

import model.Categoria;
import model.Humedad;
import model.Maduracion;
import model.Queso;
import model.Subcatego;
import model.Tecnologia;
import model.Tipoleche;
import model.Variedad;

@Named("quesos")
@ViewScoped
public class QuesosWeb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8901810005539629316L;

	private String urlServer = ConectABM.urlServer();
	private List<Queso> listquesos = new ArrayList<Queso>();
	private List<String> listcat = new ArrayList<String>();
	private List<String> listhum = new ArrayList<String>();
	private List<String> listmadu = new ArrayList<String>();
	private List<String> listsubcat = new ArrayList<String>();
	private List<String> listecno = new ArrayList<String>();
	private List<String> listipol = new ArrayList<String>();
	private List<String> listvar = new ArrayList<String>();
	private String cat;
	private String humedad;
	private String maduracion;
	private String subcat;
	private String tecno;
	private String tipol;
	private String var;
	private String descrip;
	private Queso select;
	private String modVar;
	private Gson gson = new Gson();


	

	public String getModVar() {
		return modVar;
	}

	public void setModVar(String modVar) {
		this.modVar = modVar;
	}

	public List<Queso> getListquesos() {

		listquesos = new ArrayList<Queso>();
		Queso[] quesos = gson.fromJson(ReadJson.readJsonFromUrl(urlServer+"quesos/todos"), Queso[].class);
		for (Queso q : quesos) {
			listquesos.add(q);
		}
		return listquesos;
	}

	public List<String> getListcat() {

		listcat = new ArrayList<String>();
		Categoria[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "categoria/todas"), Categoria[].class);
		for (Categoria s : list) {
			listcat.add(s.getReferencia());
		}

		return listcat;
	}

	public List<String> getListhum() {

		listhum = new ArrayList<String>();
		Humedad[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "hum/todas"), Humedad[].class);
		for (Humedad s : list) {
			listhum.add(s.getReferencia());
		}
		return listhum;
	}

	public List<String> getListmadu() {

		listmadu = new ArrayList<String>();
		Maduracion[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "maduracion/todas"), Maduracion[].class);
		for (Maduracion s : list) {
			listmadu.add(s.getReferencia());
		}

		return listmadu;
	}

	public List<String> getListecno() {

		listecno = new ArrayList<String>();
		Tecnologia[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "tecnologias/todas"), Tecnologia[].class);
		for (Tecnologia s : list) {
			listecno.add(s.getReferencia());
		}

		return listecno;
	}

	public List<String> getListipol() {

		listipol = new ArrayList<String>();
		Tipoleche[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "tipoleche/todos"), Tipoleche[].class);
		for (Tipoleche s : list) {
			listipol.add(s.getNombre());
		}

		return listipol;
	}

	public List<String> getListvar() {

		listvar = new ArrayList<String>();
		Variedad[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "variedad/todas"), Variedad[].class);
		for (Variedad s : list) {
			listvar.add(s.getNombreVar());
		}
		return listvar;
	}

	public List<String> getListsubcat() {

		listsubcat = new ArrayList<String>();
		Subcatego[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "subcat/todas"), Subcatego[].class);
		for (Subcatego s : list) {
			listsubcat.add(s.getIdentScat());
		}
		return listsubcat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getHumedad() {
		return humedad;
	}

	public void setHumedad(String humedad) {
		this.humedad = humedad;
	}

	public String getMaduracion() {
		return maduracion;
	}

	public void setMaduracion(String maduracion) {
		this.maduracion = maduracion;
	}

	public String getSubcat() {
		return subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	public String getTecno() {
		return tecno;
	}

	public void setTecno(String tecno) {
		this.tecno = tecno;
	}

	public String getTipol() {
		return tipol;
	}

	public void setTipol(String tipol) {
		this.tipol = tipol;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Queso getSelect() {
		return select;
	}

	public void setSelect(Queso select) {
		this.select = select;
	}

	public void onEdit(RowEditEvent<Queso> event) {
		FacesMessage msg = new FacesMessage("Queso Editado", event.getObject().getCodigoAuto());
		select = event.getObject();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowSelect(SelectEvent<Queso> event) {
		FacesMessage msg = new FacesMessage("Queso Seleccionado", event.getObject().getCodigoAuto());
		//select = event.getObject();
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCancel(RowEditEvent<Queso> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", event.getObject().getCodigoAuto());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowUnselect(UnselectEvent<Queso> event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", event.getObject().getCodigoAuto());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	

	public void ActualizarQS(Queso dato) {
		
		Variedad var = findvariedad(modVar);
		
		dato.setVariedad(var);

		String json = gson.toJson(dato);

		try {
			ConectABM.conectPut(json, urlServer + "quesos/update");
			FacesMessage msg = new FacesMessage("Queso Modificado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String CrearQS() {

		Queso qs = new Queso();

		qs.setHumedad(findhumedad(humedad));
		qs.setVariedad(findvariedad(var));
		qs.setCategoria(findcategoria(cat));
		qs.setMaduracion(findmaduracion(maduracion));
		qs.setTecnologia(findtecnologia(tecno));
		qs.setTipoleche(findtipoleche(tipol));
		qs.setSubcatego(findsubcategoria(subcat));

		
		String json = gson.toJson(qs);
		System.out.println(json);

		try {

			ConectABM.conectPost(json, urlServer + "quesos/crear");
			FacesMessage msg = new FacesMessage("Queso Creado");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Quesos.xhtml";
	}

	public String BorrarQS(Queso s) {
		
		String json = gson.toJson(s);

		try {

			ConectABM.conectBorrar(json, urlServer + "quesos/borrar");
			FacesMessage msg = new FacesMessage("Queso Eliminado");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Quesos.xhtml";

	}

	public Humedad findhumedad(String h) {

		Humedad obj = new Humedad();
		Humedad[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "hum/todas"), Humedad[].class);
		for (Humedad e : list) {
			if (e.getReferencia().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Variedad findvariedad(String h) {

		Variedad obj = new Variedad();
		Variedad[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "variedad/todas"), Variedad[].class);
		for (Variedad e : list) {
			if (e.getNombreVar().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Categoria findcategoria(String h) {

		Categoria obj = new Categoria();
		Categoria[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "categoria/todas"), Categoria[].class);
		for (Categoria e : list) {
			if (e.getReferencia().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Maduracion findmaduracion(String h) {

		Maduracion obj = new Maduracion();
		Maduracion[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "maduracion/todas"), Maduracion[].class);
		for (Maduracion e : list) {
			if (e.getReferencia().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Tecnologia findtecnologia(String h) {

		Tecnologia obj = new Tecnologia();
		Tecnologia[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "tecnologias/todas"), Tecnologia[].class);
		for (Tecnologia e : list) {
			if (e.getReferencia().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Tipoleche findtipoleche(String h) {

		Tipoleche obj = new Tipoleche();
		Tipoleche[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "tipoleche/todos"), Tipoleche[].class);
		for (Tipoleche e : list) {
			if (e.getNombre().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}

	public Subcatego findsubcategoria(String h) {

		Subcatego obj = new Subcatego();
		Subcatego[] list = gson.fromJson(ReadJson.readJsonFromUrl(urlServer + "subcat/todas"), Subcatego[].class);
		for (Subcatego e : list) {
			if (e.getIdentScat().equals(h)) {
				obj = e;
			}
		}

		return obj;

	}
	
	

}
