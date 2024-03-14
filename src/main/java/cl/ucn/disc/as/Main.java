package cl.ucn.disc.as;


import cl.ucn.disc.as.Services.Sistema;
import cl.ucn.disc.as.Services.SistemaIMPL;
import cl.ucn.disc.as.exceptions.IllegalDomainException;
import cl.ucn.disc.as.routes.RoutesConfigurator;
import cl.ucn.disc.as.routes.WebController;
import cl.ucn.disc.as.seeders.Seed;
import io.ebean.DB;
import io.ebean.Database;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

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

    public static Javalin createAndConfigureJavalin(Sistema sis) {
        Javalin app = Javalin.create();

        // Configuraciones adicionales después de la creación de la instancia
        app.before(ctx -> {
            // Lógica para ejecutar antes de manejar cada solicitud
        });

        app.after(ctx -> {
            // Lógica para ejecutar después de manejar cada solicitud
        });

        app.get("/salir", ctx -> {

            log.debug("Stopping...");

            app.stop();

            log.debug("Done. ^^");
        });

        // Define tus rutas y manejadores aquí utilizando app.get(), app.post(), etc.

        return app;
    }

    public static Javalin start(final int port, final RoutesConfigurator routesConfigurator, Sistema sis){

        if (port < 1024 || port > 65535){

            log.error("Bad port {}.", port);
            throw new IllegalArgumentException("Bad port: " + port);

        }
        log.debug("Starting api rest server in port {} ..", port);

        //the server
        Javalin app = createAndConfigureJavalin(sis);

        //configurar the paths
        routesConfigurator.configureRoutes(app, sis);

        //the hookup thread
        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));

        //hooks to detect the shutdown
        app.events(eventConfig -> {
           eventConfig.serverStarting(() -> {
               log.debug("Starting the javalin server ..");
           });
           eventConfig.serverStarted(() -> {
               log.debug("Server started!");
           });
           eventConfig.serverStopping(() -> {
               log.debug("Stopping the server ..");
           });
           eventConfig.serverStopped(() -> {
               log.debug("Server stopped!");
           });
        });

        //starting
        return app.start(port);
    }


    public static void main(String[] args) throws IllegalDomainException {

        log.debug("starting main...");

        log.debug("loading the database...");

        Database db = DB.getDefault();//crea la base de datos

        Sistema sistema = new SistemaIMPL(db);//crea el sisteme

        /**cargan los seeders*/
        Seed seeders = new Seed(sistema);
        seeders.LoadData(sistema);

        log.debug("loaded the database...");

        /**Esto apunta al puerto, es similar a los controladores de software donde utiliza un http y con esa
         * peticion obtiene el resultado*/

        log.debug("Beginning app...");


        /**are as controllers*/
        Javalin app = start(2026, new WebController(), sistema);

        /**
        log.debug("Stopping...");

        app.stop();

        log.debug("Done. ^^");
         */
    }

}
