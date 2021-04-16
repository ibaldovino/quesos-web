package servicios;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.google.gson.Gson;

import model.Subcatego;
import model.Usuario;

@Named("usu")
@ViewScoped
public class Usuarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = "http://dominio.ddns.net:8086/TablasQueso/rest/usuario/";
	private List<Subcatego> listusu;
	private String nomUsuario;
	private String pwdUsuario;
	

	
	
	public List<Subcatego> getListusu() {
		return listusu;
	}



	public void setListusu(List<Subcatego> listusu) {
		this.listusu = listusu;
	}



	public String getNomUsuario() {
		return nomUsuario;
	}



	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}



	public String getPwdUsuario() {
		return pwdUsuario;
	}



	public void setPwdUsuario(String pwdUsuario) {
		this.pwdUsuario = pwdUsuario;
	}



	public List<Subcatego> getSubcatego() {
		
		List<Subcatego> listsub = new ArrayList<Subcatego>();
		
		Gson gson = new Gson();
		Subcatego[] listsb = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todas"), Subcatego[].class);
		for (Subcatego s : listsb) {
			listsub.add(s);
		}
		return listsub;
	}
	
	
	
	public String ValidarUsuario(String nomAcceso, String contra){
		// Verifico que el usuario ingredado exista en la base
		Usuario usuarioAcc;
		System.out.println("------------------Datos del Usuario--------------");
		System.out.println("El usuario ingresado fue: " + nomAcceso);
		System.out.println("La password ingresada fue: " + contra);

		// Valido que el usuario ingresado exista en la base, de no ser asì mandamos
		// mensaje
		Gson gson = new Gson();
		
		usuarioAcc = gson.fromJson(ReadJson.readJsonFromUrl(rest+"usuact"+"/"+nomAcceso+"/"+contra), Usuario.class);
		
		if (usuarioAcc == null) {
			FacesMessage msg = new FacesMessage("El usuario ingresado no existe");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		} else {
			System.out.println("Login Exitoso");
			nomAcceso= "";
			contra= "";
			return "Index";
		}
		
		return null;
	}
	
	public String CerrarSesion() {
		return "Login.xhtml";
	}
	
	     

}