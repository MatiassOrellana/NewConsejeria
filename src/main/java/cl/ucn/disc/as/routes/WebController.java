package cl.ucn.disc.as.routes;

import io.javalin.Javalin;

public class WebController implements RoutesConfigurator{

    @Override
    public void configureRoutes(Javalin app) {
        // Configura tus rutas y manejadores aquí
        app.get("/", ctx -> ctx.result("¡Hola, mundo!"));
        app.get("/rutaEjemplo", ctx -> ctx.result("Esta es una ruta de ejemplo"));
        // Agrega más rutas según sea necesario
    }
}
