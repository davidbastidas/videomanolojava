/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

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
    @Path("/getListaPeliculas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListaPeliculas() {
        int size = listaPeliculas.size();
        Pelicula pelicula = new Pelicula("", "", "", "", 0, 0, "");
        listaPeliculas.add(pelicula);
        String json = new Gson().toJson(listaPeliculas);
        return json;
    }

    /**
     * POST method for creating an instance of PeliculasResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @Path("/savePelicula")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savePelicula(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }
    
    /**
     * Retrieves representation of an instance of recursos.PeliculassResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getPelicula/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPelicula(@PathParam("id") String id) {
        return id;
    }
}
