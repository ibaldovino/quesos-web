package servicios;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeFacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.google.gson.Gson;

import model.Estusuario;
import model.Role;
import model.Usuario;

@Named(value="usus")
@ViewScoped
public class UsuariosWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7120439312754432359L;

	private String rest = ConectABM.urlServer() + "usuario/";
	private Usuario select;
	private Long idUsuario;
	private String apeUsuario;
	private Date fecaltUsuario;
	private Date fecbajUsuario;
	private Date fecsusUsuario;
	private String mailUsuario;
	private String nomUsuario;
	private String pwdUsuario;
	private String telefUsuario;
	private String usuario;
	private Estusuario estusuario;
	private Role role;
	
	
	
	public String getRest() {
		return rest;
	}



	public void setRest(String rest) {
		this.rest = rest;
	}



	public Usuario getSelect() {
		return select;
	}



	public void setSelect(Usuario select) {
		this.select = select;
	}



	public long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public String getApeUsuario() {
		return apeUsuario;
	}



	public void setApeUsuario(String apeUsuario) {
		this.apeUsuario = apeUsuario;
	}



	public Date getFecaltUsuario() {
		return fecaltUsuario;
	}



	public void setFecaltUsuario(Date fecaltUsuario) {
		this.fecaltUsuario = fecaltUsuario;
	}



	public Date getFecbajUsuario() {
		return fecbajUsuario;
	}



	public void setFecbajUsuario(Date fecbajUsuario) {
		this.fecbajUsuario = fecbajUsuario;
	}



	public Date getFecsusUsuario() {
		return fecsusUsuario;
	}



	public void setFecsusUsuario(Date fecsusUsuario) {
		this.fecsusUsuario = fecsusUsuario;
	}



	public String getMailUsuario() {
		return mailUsuario;
	}



	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
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



	public String getTelefUsuario() {
		return telefUsuario;
	}



	public void setTelefUsuario(String telefUsuario) {
		this.telefUsuario = telefUsuario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public Estusuario getEstusuario() {
		return estusuario;
	}



	public void setEstusuario(Estusuario estusuario) {
		this.estusuario = estusuario;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
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

	
	
	
	//Funciones POST
	
			public String Crear() {
				
				Usuario nueva= new Usuario();
				
				nueva.setIdUsuario(idUsuario);
				nueva.setApeUsuario(apeUsuario);
				nueva.setEstusuario(null);
				nueva.setFecaltUsuario(fecaltUsuario);
				nueva.setFecbajUsuario(fecbajUsuario);
				nueva.setFecsusUsuario(fecsusUsuario);
				nueva.setMailUsuario(mailUsuario);
				nueva.setNomUsuario(nomUsuario);
				nueva.setPwdUsuario(pwdUsuario);
				nueva.setRole(null);
				nueva.setTelefUsuario(telefUsuario);
				nueva.setUsuario(usuario);
			    
				System.out.println(nueva);
				Gson gson = new Gson();
				String json = gson.toJson(nueva);
				
				try {
					
					ConectABM.conectPost(json,rest+"crear");
					FacesMessage msg = new FacesMessage("Estado Usuario Creado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
			        PrimeFaces.current().executeScript("PF('mostrar').hide()");
			        PrimeFaces.current().ajax().update("form:UsuarioTabla");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "Usuario.xhtml";
			}
			
			
			public String Borrar (Usuario v) {
				System.out.print(v);
			
			
			Gson gson = new Gson();
			String json = gson.toJson(v);
			
			try {
				
				ConectABM.conectBorrar(json,rest+"borrar");
				FacesMessage msg = new FacesMessage("Estado Usuario Eliminado");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Usuario.xhtml";
			
			}
			
			public void Actualizar (Usuario var) {
				
				
				
				Gson gson = new Gson();
				String json = gson.toJson(var);
				
				try {
					ConectABM.conectPut(json,rest+"update");
					FacesMessage msg = new FacesMessage("Estado Usuario Modificado");
			        FacesContext.getCurrentInstance().addMessage(null, msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//return "SubCat.xhtml";
			}
			
			public void onRowSelect(SelectEvent<Usuario> event) {
				String s= String.valueOf(event.getObject().getIdUsuario());
		        FacesMessage msg = new FacesMessage("Estado Usuario Seleccionado", s);
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }
			
			public void onRowCancel(RowEditEvent<Usuario> event) {
				FacesMessage msg = new FacesMessage("Edicion Cancelada", String.valueOf(event.getObject().getIdUsuario()));
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
			
			
			
		    public void onRowUnselect(UnselectEvent<Usuario> event) {
		    	String s= String.valueOf(event.getObject().getIdUsuario());
		        FacesMessage msg = new FacesMessage("Estado Usuario Deseleccionado", s);
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		    }	
		    
		   
			
		    
		    	     

}