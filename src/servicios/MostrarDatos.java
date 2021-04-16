package servicios;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Camara;
import model.Departamento;
import model.Estusuario;
import model.Evadescrip;
import model.Evaluacione;
import model.Evatipo;
import model.Habijurado;
import model.Habilidade;
import model.Humedad;
import model.Inscripcione;
import model.Juracateg;
import model.Jurado;
import model.Localidade;
import model.Maduracion;
import model.Mesa;
import model.Mesajura;
import model.Pais;
import model.Participante;
import model.Queso;
import model.Role;
import model.Roltarea;
import model.Subcatego;
import model.Tarea;
import model.Tecnologia;
import model.Tipindustria;
import model.Tipoleche;
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
	private List<Departamento> departamento;
	private List<Pais> pais;
	private List<Estusuario> est;
	private List<Evadescrip> evaDescrip;
	private List<Evatipo> evaTipos;
	private List<Tarea> tareas;
	private List<Tipoleche> tiposLec;
	private List<Tipindustria> tiposInd;
	private List<Evaluacione> evaluaciones;
	private List<Role> rolesV;
	private List<Roltarea> roltareas;
	private List<Localidade> localidades;
	private List<Inscripcione> inscripciones;
	private List<Juracateg> juraCategos;
	private List<Mesajura> mesajurados;
	private List<Participante> participantes;
	private List<Habijurado> habijurados;
    
         
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
    private DepartamentoWeb serdep;
    @Inject
    private PaisWeb serpais;
    @Inject
    private EstUsuarioWeb serestu;
    @Inject
    private EvaDescripWeb serevadescr;
    @Inject
    private EvaTipoWeb serevatip;
    @Inject
    private TareaWeb sertarea;
    @Inject
    private TipLecheWeb sertiplec;
    @Inject
    private TipIndustriaWeb sertipind;
    @Inject
    private EvaluacioneWeb serEvaluac;
    @Inject
    private RolTareaWeb serroltarea;
    @Inject
    private RolWeb serrol;
    @Inject
    private InscripcionesWeb serinscrip;
    @Inject
    private JuraCategWeb serjuracateg;
    @Inject
    private MesaJuraWeb sermesajur;
    @Inject
    private LocalidadWeb serlocalidades;
    @Inject
    private ParticipanteWeb serparticipantes;
    @Inject
    private HabiJuradoWeb serhabijurados;
    
     
    @PostConstruct
    public void init() {
    	subcateg = sersubcat.getSubcatego();
    	quesos = serqs.getListquesos();
    	usuarios = serusu.getUsuarios();
    	humedades= serhum.getHumedades();
    	variedades= servar.getVariedades();
    	tecnologias= sertec.getTecnologias();
    	maduracion= sermad.getMaduracion();
    	mesas= sermes.getMesas();
    	jurados= serjur.getJurados();
    	camaras= sercam.getCamaras();
    	habilidad= serhab.getHabilidades();
    	departamento= serdep.getDepartamentos();
    	pais= serpais.getPaises();
    	est= serestu.getEstusuarios();
    	evaDescrip= serevadescr.getEvadescrips();
    	evaTipos= serevatip.getEvatipoes();
    	tareas= sertarea.getTareas();
    	tiposLec= sertiplec.getTiposLeche();
    	tiposInd= sertipind.getTipindus();
    	evaluaciones= serEvaluac.getEvaluaciones();
    	rolesV= serrol.getRole();
    	roltareas= serroltarea.getRoltarea();
    	localidades= serlocalidades.getLocalidade();
    	mesajurados= sermesajur.getMesajura();
    	inscripciones= serinscrip.getInscripcione();
    	juraCategos=serjuracateg.getJuracateg();
    	participantes= serparticipantes.getParticipantes();
    	habijurados= serhabijurados.getHabijurado();
    }
    
    

	public List<Habijurado> getHabijurados() {
		return habijurados;
	}



	public void setHabijurados(List<Habijurado> habijurados) {
		this.habijurados = habijurados;
	}



	public List<Participante> getParticipantes() {
		return participantes;
	}



	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}



	public List<Role> getRolesV() {
		return rolesV;
	}



	public void setRoles(List<Role> rolesV) {
		this.rolesV = rolesV;
	}



	public List<Roltarea> getRoltareas() {
		return roltareas;
	}


	public void setRoltareas(List<Roltarea> roltareas) {
		this.roltareas = roltareas;
	}


	public List<Localidade> getLocalidades() {
		return localidades;
	}



	public void setLocalidades(List<Localidade> localidades) {
		this.localidades = localidades;
	}


	public List<Inscripcione> getInscripciones() {
		return inscripciones;
	}


	public void setInscripciones(List<Inscripcione> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public List<Juracateg> getJuraCategos() {
		return juraCategos;
	}

	public void setJuraCategos(List<Juracateg> juraCategos) {
		this.juraCategos = juraCategos;
	}

	public List<Mesajura> getMesajurados() {
		return mesajurados;
	}



	public void setMesajurados(List<Mesajura> mesajurados) {
		this.mesajurados = mesajurados;
	}


	public List<Evaluacione> getEvaluaciones() {
		return evaluaciones;
	}



	public void setEvaluaciones(List<Evaluacione> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}


	public List<Estusuario> getEst() {
		return est;
	}



	public void setEst(List<Estusuario> est) {
		this.est = est;
	}


	public List<Evadescrip> getEvaDescrip() {
		return evaDescrip;
	}


	public void setEvaDescrip(List<Evadescrip> evaDescrip) {
		this.evaDescrip = evaDescrip;
	}


	public List<Evatipo> getEvaTipos() {
		return evaTipos;
	}


	public void setEvaTipos(List<Evatipo> evaTipos) {
		this.evaTipos = evaTipos;
	}




	public List<Tarea> getTareas() {
		return tareas;
	}




	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}




	public List<Tipoleche> getTiposLec() {
		return tiposLec;
	}




	public void setTiposLec(List<Tipoleche> tiposLec) {
		this.tiposLec = tiposLec;
	}




	public List<Tipindustria> getTiposInd() {
		return tiposInd;
	}




	public void setTiposInd(List<Tipindustria> tiposInd) {
		this.tiposInd = tiposInd;
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
