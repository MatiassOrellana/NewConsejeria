package cl.ucn.disc.as.routes;

import cl.ucn.disc.as.Services.Sistema;
import cl.ucn.disc.as.dto.DeptoDTO;
import cl.ucn.disc.as.dto.PersonaDTO;
import cl.ucn.disc.as.exceptions.ErrorResponse;
import cl.ucn.disc.as.model.Depto;
import cl.ucn.disc.as.model.Persona;
import io.javalin.Javalin;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WebController implements RoutesConfigurator{

    @Override
    public void configureRoutes(Javalin app, Sistema sis) {
        // Configura tus rutas y manejadores aquí
        app.get("/", ctx -> ctx.result("¡Hola, mundo!"));
        app.get("/rutaEjemplo", ctx -> ctx.result("Esta es una ruta de ejemplo"));

        app.get("/deptos", ctx -> {
            try {
                List<Depto> listaDeptos = sis.getDeptosByDB();

                // Mapea la lista de personas a una lista de DTO (Data Transfer Object)
                List<DeptoDTO> listaDeptosDTO = listaDeptos.stream()
                        .map(depto -> new DeptoDTO(depto.getNumero(), depto.getPiso()))
                        .collect(Collectors.toList());

                ctx.json(listaDeptosDTO);

            } catch (Exception e) {
                e.printStackTrace(); // Imprime la pila de llamadas en la consola
                ctx.status(500).json(new ErrorResponse("Server Error", 500, "https://javalin.io/documentation#internalservererrorresponse", Collections.emptyMap()));
            }
        });

        app.get("/personas", ctx -> {
            try {
                List<Persona> listaPersonas = sis.getPersonasByDB();

                // Mapea la lista de personas a una lista de DTO (Data Transfer Object)
                List<PersonaDTO> listaPersonasDTO = listaPersonas.stream()
                        .map(persona -> new PersonaDTO(persona.getRut(), persona.getNombre(), persona.getApellidos()
                                ,persona.getEmail(), persona.getTelefono()))
                        .collect(Collectors.toList());

                ctx.json(listaPersonasDTO);

            } catch (Exception e) {
                e.printStackTrace(); // Imprime la pila de llamadas en la consola
                ctx.status(500).json(new ErrorResponse("Server Error", 500, "https://javalin.io/documentation#internalservererrorresponse", Collections.emptyMap()));
            }
        });

        // Agrega más rutas según sea necesario
    }
}
