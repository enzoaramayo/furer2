/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Full Stackers
 */
public class ListaUsuarios implements Serializable {

    private List<Usuario> listaUsuarios;
    private List<Usuario> resultado;

    public ListaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("Enzo Aramayo", "23", "root", "apu2008"));
        listaUsuarios.add(new Usuario("Rumbolo", "1", "rumbolo", "rumbolo"));
        listaUsuarios.add(new Usuario("Joh Smith", "1", "jhon", "jhon"));
        listaUsuarios.add(new Usuario("Alumno", "1", "alumno", "alumno"));
        listaUsuarios.add(new Usuario("Neo", "1", "matrix", "matrix"));
        listaUsuarios.add(new Usuario("Morfeo", "1", "sueño", "sueño"));
    }

    public void agregarUsuario(Usuario nuevo) {
        listaUsuarios.add(nuevo);
    }

    public void borrarUsuario(Usuario borrado) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(borrado.getUsuario())) {
                listaUsuarios.remove(i);
            }
        }
    }

    public boolean verificarSiUsuarioExiste(Usuario nuevo) {
        boolean existe = false;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(nuevo.getUsuario())) {
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean concederAcceso(Usuario login){
        boolean logeado = false;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getUsuario().equals(login.getUsuario()) &&
                    listaUsuarios.get(i).getContraseña().equals(login.getContraseña())) {
                logeado= true;
            }
        }
        return logeado;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getResultado() {
        return resultado;
    }

    public void setResultado(List<Usuario> resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ListaUsuarios{" + "listaUsuarios=" + listaUsuarios + ", resultado=" + resultado + '}';
    }

}
