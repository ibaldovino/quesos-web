package servicios;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import model.Camara;
import model.Usuario;



@Named(value="ControlLogin")
@SessionScoped
public class ControlLogin implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -82797090124495901L;


private String server = ConectABM.urlServer() + "usuario/";

@ManagedProperty("#{loginManager.logins}")
private Set<Usuario> logins;

private String nickname;
private String clave;
private Usuario p;
//g+s+

public String Login() {
FacesContext context=FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
try {
    request.login(nickname, clave);//si existe error en el login salta el error y no permite que se loguee otra vez
    
    Gson gson = new Gson();
	p = gson.fromJson(ReadJson.readJsonFromUrl(server +"usuact/" + nickname + "/" + clave), Usuario.class);
   
    if(p!=null) {
       if(!logins.contains(p)){
         logins.add(p);
         return "pagina?faces-redirect=true";
       }
    }
}catch(Exception e) {
    System.out.println(e);
}
return null;
}

public String ValidarUsuario(String nomAcceso, String contra) {

	Usuario usua = new Usuario();
    Gson gson = new Gson();		
    usua = gson.fromJson(ReadJson.readJsonFromUrl(server+"usuact"+"/"+nomAcceso+"/"+contra), Usuario.class);
    System.out.println(nomAcceso + contra);
	/*
	 * System.out.println(usua.getNomUsuario() + "  " + usua.getApeUsuario() );
	 * String nom, pass; nom = usua.getUsuario(); pass = usua.getPwdUsuario();
	 */

	String retur = null;
	
	if (usua != null) {
		System.out.println(nomAcceso +" //"+ contra);
		 if (nomAcceso.equals(usua.getNomUsuario()) && contra.equals(usua.getPwdUsuario())) { 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usua);
			retur = "Index.xhtml";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Atencion!", "Usuario y/o Contraseña Incorrecta"));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usua);
			retur = "Login.xhtml";
		}
	}
	return retur;
}


public void verificarSession() {
	System.out.println("Estoy verificando session de usuario");
	try {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario usu = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
		//System.out.println(usu.getNomUsuario());
		if(usu == null) {
			context.getExternalContext().redirect("Login.xhtml");
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atencion!",
					  "Usuario y/o Contraseña no ingresados"));
		}
		
	}catch (Exception e){
		System.out.println("problema" + e);
	}
	
}

public String cerrarSesion() {
	
	System.out.println("Intento cerrar session");
	Usuario usu = null;
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usu);
	FacesMessage msg = new FacesMessage("Sesion cerrada");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	   
	String s = "Login.xhtml";
	return s;
	
	/*
	 * FacesContext context = PrimeFacesContext.getCurrentInstance(); try {
	 * context.getExternalContext().redirect(rest + "Login.xhtml"); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 */
}
}
