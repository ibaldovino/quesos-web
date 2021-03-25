package servicios;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import model.Camara;
import model.Categoria;
import model.Departamento;
import model.Habilidade;
import model.Humedad;
import model.Jurado;
import model.Maduracion;
import model.Mesa;
import model.Pais;
import model.Queso;
import model.Subcatego;
import model.Tecnologia;
import model.Usuario;
import model.Variedad;


//@SuppressWarnings("serial")
@Named("dtEditView")
@ViewScoped

public class MostrarDatos implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List<Subcatego> subcateg;
	private List<Queso> quesos;
	private List<Usuario> usuarios;
	private List<Humedad> humedades;
	private List<Variedad> variedades;
	private List<Tecnologia> tecnologias;
	private List<Mesa> mesas;
	private List<Maduracion> maduracion;
	private List<Jurado> jurados;
	private List<Camara> camaras;
	private List<Habilidade> habilidad;
	private List<Categoria> categoria;
	private List<Departamento> departamento;
	private List<Pais> pais;
    
         
    @Inject
    private SubcategoWeb sersubcat;
    @Inject
    private QuesosWeb serqs;
    @Inject
    private UsuariosWeb serusu;
    @Inject
    private HumedadWeb serhum;
    @Inject
    private VariedadWeb servar;
    @Inject
    private TecnologiaWeb sertec;
    @Inject
    private MaduracionWeb sermad;
    @Inject
    private MesaWeb sermes;
    @Inject
    private JuradoWeb serjur;
    @Inject
    private CamaraWeb sercam;
    @Inject
    private HabilidadWeb serhab;
    @Inject
    private CategoriaWeb sercateg;
    @Inject
    private DepartamentoWeb serdep;
    @Inject
    private PaisWeb serpais;
     
    @PostConstruct
    public void init() {
    	subcateg = sersubcat.getSubcatego();
    	quesos = serqs.getListquesos();
    	usuarios = serusu.getListusu();
    	humedades= serhum.getHumedades();
    	variedades= servar.getVariedades();
    	tecnologias= sertec.getTecnologias();
    	maduracion= sermad.getMaduracion();
    	mesas= sermes.getMesas();
    	jurados= serjur.getJurados();
    	camaras= sercam.getCamaras();
    	habilidad= serhab.getHabilidades();
    	categoria= sercateg.getListcateg();
    	departamento= serdep.getDepartamentos();
    	pais= serpais.getPaises();
    }
    
    public List<Pais> getPais() {
		return pais;
	}




	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}




	public List<Departamento> getDepartamento() {
		return departamento;
	}




	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
	}
    
    
    
 
    public List<Categoria> getCategoria() {
		return categoria;
	}





	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}





	public void setQuesos(List<Queso> quesos) {
		this.quesos = quesos;
	}





	public List<Habilidade> getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(List<Habilidade> habilidad) {
		this.habilidad = habilidad;
	}


	public List<Camara> getCamaras() {
		return camaras;
	}


	public void setCamaras(List<Camara> camaras) {
		this.camaras = camaras;
	}






	public List<Jurado> getJurados() {
		return jurados;
	}






	public void setJurados(List<Jurado> jurados) {
		this.jurados = jurados;
	}






	public List<Maduracion> getMaduracion() {
		return maduracion;
	}






	public void setMaduracion(List<Maduracion> maduracion) {
		this.maduracion = maduracion;
	}






	public List<Mesa> getMesas() {
		return mesas;
	}






	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}






	public List<Tecnologia> getTecnologias() {
		return tecnologias;
	}





	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}





	public List<Variedad> getVariedades() {
		return variedades;
	}




	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}




	public List<Humedad> getHumedades() {
		return humedades;
	}




	public void setHumedades(List<Humedad> humedades) {
		this.humedades = humedades;
	}


    
    public List<Subcatego> getSubcateg() {
		return subcateg;
	}




	public void setSubcateg(List<Subcatego> subcateg) {
		this.subcateg = subcateg;
	}




	public List<Queso> getQuesos() {
		return quesos;
	}
    
    public List<Usuario> getUsuarios() {
		return usuarios;
	}
    
    public void setSersubcat(SubcategoWeb sersubcat) {
        this.sersubcat = sersubcat;
    }

	

	public void setSerqs(QuesosWeb serqs) {	
		this.serqs = serqs;	
		}

	

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuariosWeb getSerusu() {
		return serusu;
	}

	public void setSerusu(UsuariosWeb serusu) {
		this.serusu = serusu;
	}
	
	
    
       
    
}
