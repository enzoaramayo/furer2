/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.modelo.util.ListaUsuarios;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Full Stackers
 */
public class ListaUsuariosDAOImp implements Serializable, IUsuarioDAO {
    
    private ListaUsuarios listadoDeUsuarios;
    
    public ListaUsuariosDAOImp() {
        listadoDeUsuarios = new ListaUsuarios();
    }
    
    @Override
    public void agregarUsuario(Usuario nuevo) {
        listadoDeUsuarios.agregarUsuario(nuevo);
    }
    
    @Override
    public void borrarUsuario(Usuario borrado) {
        listadoDeUsuarios.borrarUsuario(borrado);
    }
    
    @Override
    public boolean verificarSiUsuarioExiste(Usuario nuevo) {
        return listadoDeUsuarios.verificarSiUsuarioExiste(nuevo);
    }
    
    @Override
    public List<Usuario> obtener() {
        return listadoDeUsuarios.getListaUsuarios();
    }
    
    public ListaUsuarios getListadoDeUsuarios() {
        return listadoDeUsuarios;
    }
    
    public void setListadoDeUsuarios(ListaUsuarios listadoDeUsuarios) {
        this.listadoDeUsuarios = listadoDeUsuarios;
    }
    
    @Override
    public String toString() {
        return "ListaUsuariosDAOImp{" + "listadoDeUsuarios=" + listadoDeUsuarios + '}';
    }

    @Override
    public boolean acceder(Usuario login) {
        return listadoDeUsuarios.concederAcceso(login);
    }
    
}
