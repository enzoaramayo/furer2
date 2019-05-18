package aplicacion.controlador.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

@ManagedBean
@ViewScoped
public class UploaderBean implements Serializable {

    private Part pelicula;

    public Part getPelicula() {
        return pelicula;
    }

    public void setPelicula(Part pelicula) {
        this.pelicula = pelicula;
    }

    public String upload() throws IOException {

        pelicula.write("C:/Users/Enzo/Documents/NetBeansProjects/Peliculas/web/peliculas/" + getFilename(pelicula));
        return "success";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}

