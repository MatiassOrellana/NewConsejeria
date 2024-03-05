package cl.ucn.disc.as.routes;

import io.javalin.Javalin;

public interface RoutesConfigurator {
    void configureRoutes(Javalin app);
}
