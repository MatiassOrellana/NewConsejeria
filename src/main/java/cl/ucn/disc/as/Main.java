package cl.ucn.disc.as;


import cl.ucn.disc.as.Services.Sistema;
import cl.ucn.disc.as.Services.SistemaIMPL;
import cl.ucn.disc.as.connectionSQL.DatabaseConnection;
import cl.ucn.disc.as.model.*;
import cl.ucn.disc.as.seeders.Seed;
import io.ebean.DB;
import io.ebean.Database;
import io.ebeaninternal.server.util.Str;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Main
 *
 * @autor Matias orellana
 */

@Slf4j //simple login faltale for java, nos injecta un atributo del logger
//entrega mucho mas imformacion que el system.out.print ln
//nombre de la clase
//la hora, todo
public class Main {




    private static List<Persona> obtenerListaPersonas() {
        List<Persona> personas = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT rut,nombre,apellidos,email,telefono FROM persona";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String rut = resultSet.getString("rut");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String email = resultSet.getString("email");
                    String telefono = resultSet.getString("telefono");

                    Persona newPersona = new Persona(rut,nombre,apellidos,email,telefono,null);

                    personas.add(newPersona);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo adecuado de las excepciones en un entorno real
        }

        return personas;
    }


    public static void main(String[] args) {

        log.debug("starting main...");

        Database db = DB.getDefault();//crea la base de datos

        Sistema sistema = new SistemaIMPL(db);

        Seed seeders = new Seed(sistema);

        seeders.LoadData(sistema);

        /**Esto apunta al puerto, es similar a los controladores de software donde utiliza un http y con esa
         * peticion obtiene el resultado*/

        /**are as controllers*/
        Javalin app = Javalin.create().start(2026);
        app.get("/", ctx -> ctx.result("Hola chavo"));



        app.get("/personas", ctx -> {
            List<Persona> listaPersonas = obtenerListaPersonas();
            ctx.json(listaPersonas);
        });
    }

}
