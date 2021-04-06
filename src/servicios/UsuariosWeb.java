package servicios;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.google.gson.Gson;


import model.Usuario;

@Named("usus")
@ViewScoped
public class UsuariosWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "usuario/";
	private List<Usuario> listusu;
	private String nomUsuario;
	private String pwdUsuario;
	

	
	
	public List<Usuario> getListusu() {
		return listusu;
	}



	public void setListusu(List<Usuario> listusu) {
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

	
	
	public List<Usuario> getUsuarios() {
		List<Usuario> listusers = new ArrayList<Usuario>();
		Gson gson = new Gson();
		Usuario[] listusus = gson.fromJson(ReadJson.readJsonFromUrl(rest+"todos"), Usuario[].class);
		for (Usuario u : listusus) {
			listusers.add(u);
		}
		return listusers;
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
	
	     

}