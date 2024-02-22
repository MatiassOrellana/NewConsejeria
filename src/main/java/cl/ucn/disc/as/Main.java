package cl.ucn.disc.as;


import cl.ucn.disc.as.Services.Sistema;
import cl.ucn.disc.as.Services.SistemaIMPL;
import cl.ucn.disc.as.model.*;
import io.ebean.DB;
import io.ebean.Database;
import io.ebeaninternal.server.util.Str;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.IOException;
import java.util.Date;

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

    public static Edificio EdificioBuilder(String nombre, String direccion, Sistema sis){

        Edificio edificio = Edificio.builder().nombre(nombre).direccion(direccion).build();

        return sis.addEdificio(edificio);

    }

    public static Persona PersonaBuilder(String rut, String nombre, String apellidos, String email, String telefono, Sistema sis){

        Persona persona = Persona.builder().rut(rut).nombre(nombre).apellidos(apellidos).email(email).telefono(telefono).build();

        return sis.addPersona(persona);

    }

    public static Depto DeptoBuilder(String numero, String piso, Edificio edificio, Sistema sis){

        Long IDEdificio = edificio.getId();
        Depto depto = Depto.builder().numero(numero).piso(piso).IDEdificio(IDEdificio).build();

        return sis.addDepto(depto, IDEdificio);

    }

    public static Contrato ContratoBuilder(Persona dueño, Depto depto, Sistema sis){

        Long IDDueño = dueño.getId();
        Date actual = LocalDate.now().toDate();
        Contrato contrato = Contrato.builder().fechaDeContrato(actual).dueñoID(dueño.getId()).build();
        return sis.addContrato(IDDueño, depto, contrato);

    }

    public static Pago PagoBuilder(Double monto, Contrato contrato){

        Date actual = LocalDate.now().toDate();
        return Pago.builder().fecha(actual).monto(monto).contratoID(contrato.getId()).build();

    }





    public static void main(String[] args) {

        log.debug("starting main...");

        Database db = DB.getDefault();//crea la base de datos

        Sistema sistema = new SistemaIMPL(db);

        /*
        * agregar edificios
        **/
        Edificio edificio = EdificioBuilder("y1", "av. perez zujovic 099", sistema);
        Edificio edificio1 = EdificioBuilder("calipso", "Enrique segoviano", sistema);
        Edificio edificio2 = EdificioBuilder("y2", "av. jorge gonzalez 301", sistema);

        log.debug("edificio after dc: {}",edificio);
        log.debug("edificio after dc: {}",edificio1);
        log.debug("edificio after dc: {}",edificio2);

        /*
         * agregar personas
         **/

        Persona persona1 = PersonaBuilder("20040819-5", "Matias", "Orellana Hormazabal", "matias.orellana@alumnos.ucn.cl", "+56213671283", sistema);
        Persona persona2 = PersonaBuilder("20416699-4", "Oscar", "Laura Hurtado", "oscarLauraH@gmail.com", "+56245465466", sistema);

        /*
         * agregar deptos
         **/

        Depto depto1 = DeptoBuilder("01", "1", edificio, sistema);
        Depto depto2 = DeptoBuilder("02", "1", edificio, sistema);
        Depto depto3 = DeptoBuilder("01", "1", edificio1, sistema);
        Depto depto4 = DeptoBuilder("02", "1", edificio1, sistema);
        Depto depto5 = DeptoBuilder("01", "1", edificio2, sistema);
        Depto depto6 = DeptoBuilder("02", "1", edificio2, sistema);
        Depto depto7 = DeptoBuilder("01", "2", edificio2, sistema);

        /*
         * agregar contratos
         **/

        Contrato contrato = ContratoBuilder(persona1, depto1, sistema);
        Contrato contrato1 = ContratoBuilder(persona1, depto2, sistema);

        /* Se han agregado objetos
        donde se escribe el builder y con el builder se van añadiendo cada parametro
        con ese parametro termina en .build









        contrato.getDeptos().add(depto1);
        contrato1.getDeptos().add(depto2);

        Pago pago1 = PagoBuilder(34.1, contrato);
        Pago pago2 = PagoBuilder(41.4, contrato);
        Pago pago3 = PagoBuilder(37.4, contrato1);




        db.save(persona1);//guarda la persona a la base de datos
        db.save(persona2);
        db.save(edificio);
        db.save(edificio1);
        db.save(depto1);
        db.save(depto2);
        db.save(depto3);
        db.save(depto4);
        db.save(depto5);
        db.save(depto6);
        db.save(depto7);
        db.save(pago1);
        db.save(pago2);
        db.save(pago3);
        // la base de datos utiliza SQLite
        // consejeria.db esa es la base de datos

        log.debug("The Persona: ${}", persona1);


//        PersonaFinder df = new PersonaFinder();//creador de objeto
//        Optional<Persona> oPersona = df.byRut("20416699-4");//opcional de la persona en caso de nulos
//        oPersona.ifPresent(p -> log.debug("Persona: {}", p));//busca la persona con ese rut

        log.debug("Done.  ");

**/
    }

}
