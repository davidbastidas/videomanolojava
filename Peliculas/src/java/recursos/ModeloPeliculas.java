package recursos;

import entidades.Pelicula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ModeloPeliculas {

    // Instancias la clase que hemos creado anteriormente
    private ConexionMySQL SQL = new ConexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    // Query que usarás para hacer lo que necesites
    private String sSQL = "";

    public ArrayList<Pelicula> getAllMovies() {
        ArrayList<Pelicula> lista = new ArrayList<>();
        Pelicula movie = null;
        sSQL = "select * from peliculas";
        try {
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                movie = new Pelicula(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7), 
                        rs.getString(8));
                lista.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }
        return lista;
    }

    public ArrayList<Pelicula> getMovieForName(String nombre) {
        ArrayList<Pelicula> lista = new ArrayList<>();
        Pelicula movie = null;
        sSQL = "select * from peliculas where nombre like '%?%' ";
        try {
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setString(1, nombre);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                movie = new Pelicula(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getString(8));
                lista.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Pelicula getMovieForId(int id) {
        Pelicula movie = null;
        sSQL = "select * from peliculas where id = ?' ";
        try {
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                movie = new Pelicula(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getInt(7),
                        rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movie;
    }

    public void saveMovie(Pelicula movie) {
        // Query
        sSQL = "INSERT INTO peliculas (nombre, descripcion, director, genero, precio, cantidad, url_caratula) "+
               "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(sSQL);
            pstm.setString(1, movie.getNombre());
            pstm.setString(2, movie.getDescripcion());
            pstm.setString(3, movie.getDirector());
            pstm.setString(4, movie.getGenero());
            pstm.setFloat(5, movie.getPrecio());
            pstm.setInt(6, movie.getCantidad());
            pstm.setString(7, movie.getCaratula());
            pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPeliculas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
