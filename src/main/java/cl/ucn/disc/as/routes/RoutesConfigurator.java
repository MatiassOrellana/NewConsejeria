package cl.ucn.disc.as.routes;

import cl.ucn.disc.as.Services.Sistema;
import io.javalin.Javalin;

public interface RoutesConfigurator {
    void configureRoutes(Javalin app, Sistema sis);
}
