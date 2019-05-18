/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Full Stackers
 */
@ManagedBean
@ViewScoped
public class CatalogoBean implements Serializable {

    private List<String> peliculas;

    @PostConstruct
    public void iniciarCatalogo() {
        peliculas = new ArrayList<>();
        peliculas.add("hackers.jpg");
        peliculas.add("matrix.jpg");
        peliculas.add("matrix_reloaded.jpg");
        peliculas.add("matrix_revolutions.jpg");
        peliculas.add("rocky_iv.jpg");
        peliculas.add("avengers.jpg");
        peliculas.add("dragon_ball.jpg");      
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return "CatalogoBean{" + "peliculas=" + peliculas + '}';
    }

}
