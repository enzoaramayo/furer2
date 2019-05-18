/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.imp.ListaUsuariosDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Full Stackers
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario nuevo;
    private boolean logeado = false;
    private IUsuarioDAO listaUsuarios;

    @PostConstruct
    public void init() {
        nuevo = new Usuario();
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        nuevo = new Usuario();
        listaUsuarios = new ListaUsuariosDAOImp();
    }

    public String login() {
        String redireccionado = "";
        FacesContext context = FacesContext.getCurrentInstance();
        if (nuevo.getUsuario().equals("admin") && nuevo.getContraseña().equals("admin")) {
            logeado = true;
            redireccionado = "catalogoAdmin?faces-redirect=true";
        } else if (listaUsuarios.acceder(nuevo)) {
            logeado = true;
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", "Conexión exitosa"));
            redireccionado = "catalogoCliente?faces-redirect=true";
        } else {
            logeado = false;
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Lo sentimos",
                            "El usuario o contraseña son incorrectas"));
        }
        return redireccionado;
    }

    public String crearCuenta() {
        String redireccionado = "";
        FacesContext context = FacesContext.getCurrentInstance();
        if (listaUsuarios.verificarSiUsuarioExiste(nuevo) == false) {
            listaUsuarios.agregarUsuario(nuevo);
            redireccionado = "catalogoCliente?faces-redirect=true";
        } else {
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Lo sentimos",
                            "El usuario ya existe"));
            redireccionado = "crearCuenta?faces-redirect=true";
        }
        return redireccionado;
    }

    public void borrar(Usuario borrado) {
        listaUsuarios.borrarUsuario(borrado);
    }

    public List<Usuario> mostrarUsuarios() {
        return listaUsuarios.obtener();
    }

    public IUsuarioDAO getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(IUsuarioDAO listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getNuevo() {
        return nuevo;
    }

    public void setNuevo(Usuario nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    @Override
    public String toString() {
        return "LoginBean{" + "nuevo=" + nuevo + ", logeado=" + logeado + ", listaUsuarios=" + listaUsuarios + '}';
    }

}
