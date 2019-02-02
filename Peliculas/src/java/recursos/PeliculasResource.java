package recursos;

import com.google.gson.Gson;
import entidades.Pelicula;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author YOGA 520
 */
@Path("/peliculas")
public class PeliculasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PeliculassResource
     */
    public PeliculasResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.PeliculassResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getLista")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListaPeliculas() {
        ModeloPeliculas m = new ModeloPeliculas();
        ArrayList<Pelicula> allMovies = m.getAllMovies();
        String json = new Gson().toJson(allMovies);
        return json;
    }
    
    /**
     * Retrieves representation of an instance of recursos.PeliculassResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getPelicula/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPelicula(@PathParam("id") String id) {
        ModeloPeliculas m = new ModeloPeliculas();
        Pelicula movie = m.getMovieForId(Integer.parseInt(id));
        String json = new Gson().toJson(movie);
        return json;
    }
    
    /**
     * Retrieves representation of an instance of recursos.PeliculassResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getPelicula/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPeliculaNombre(@PathParam("nombre") String nombre) {
        ModeloPeliculas m = new ModeloPeliculas();
        ArrayList<Pelicula> allMovies = m.getMovieForName(nombre);
        String json = new Gson().toJson(allMovies);
        return json;
    }

    /**
     * POST method for creating an instance of PeliculasResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String savePelicula(String content) {
        Gson gson = new Gson();
        Pelicula movie = gson.fromJson(content, Pelicula.class);
        
        return "";
    }
}
