package cl.ucn.disc.as.seeders;

import cl.ucn.disc.as.Services.Sistema;
import cl.ucn.disc.as.exceptions.IllegalDomainException;
import cl.ucn.disc.as.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import net.datafaker.service.FakeValuesService;
import net.datafaker.service.RandomService;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.Locale;

@Slf4j
@Getter
@AllArgsConstructor
public class Seed {

    private Sistema sistema;
    /**
     * Procedimeinto para construir edificio llamando a builder
     */
    public Edificio EdificioBuilder(String nombre, String direccion, Sistema sis){

        /**construye el edificio*/
        Edificio edificio = Edificio.builder().nombre(nombre).direccion(direccion).build();

        /**retornando al utilizar el sistema para añadir al edificio*/
        return sis.addEdificio(edificio);

    }

    /**
     * Procedimeinto para construir a la persona llamando a builder similar al edificio
     */
    public Persona PersonaBuilder(String rut, String nombre, String apellidos, String email, String telefono, Sistema sis) {

        try {

            Persona persona = Persona.builder().rut(rut).nombre(nombre).apellidos(apellidos).email(email).telefono(telefono).build();

            return sis.addPersona(persona);

        } catch (IllegalDomainException w){

            return null;
        }
    }

    /**
     * Procedimeinto para construir al departamento llamando a builder similar al edificio
     * a diferencia que se debe obtener la ID del edificio debido a que es una relacion de 1 a N
     */
    public Depto DeptoBuilder(String numero, String piso, Edificio edificio, Sistema sis){

        Long IDEdificio = edificio.getId();//obtiene la ID
        Depto depto = Depto.builder().numero(numero).piso(piso).IDEdificio(IDEdificio).build();

        return sis.addDepto(depto, IDEdificio);

    }

    /**
     * Procedimeinto para construir al contrato llamando a builder similar al edificio
     * a diferencia que se debe obtener la ID del depto debido a que es una relacion de 1 a N
     * y tambien se debe vincular con la id de la persona
     * y como tiene la fecha, se le asigna la actual
     */
    public Contrato ContratoBuilder(Persona dueño, Depto depto, Sistema sis){

        //se obtienen las IDS
        Long IDDueño = dueño.getId();
        Long IDDepto = depto.getId();
        //asigna la fecha actual y la hora actual
        DateTime actual = DateTime.now();
        Contrato contrato = Contrato.builder().fechaDeContrato(actual).build();
        return sis.addContrato(IDDueño, IDDepto, contrato);

    }

    /**
     * Procedimeinto para construir al contrato llamando a builder similar al edificio
     * a diferencia que se debe obtener la ID del contrato debido a que es una relacion de 1 a N
     * y como tiene la fecha, se le asigna la actual
     */
    public Pago PagoBuilder(Double monto, Contrato contrato, Sistema sis){

        //se obtienen las IDS
        Long IDContrato = contrato.getId();
        //asigna la fecha actual y la hora actual
        DateTime actual = DateTime.now();
        Pago pago = Pago.builder().fecha(actual).monto(monto).build();
        return sis.addPago(pago,IDContrato);

    }

    public void LoadData(Sistema sistema) throws IllegalDomainException {

        /*
         * agregar edificios
         *
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

        /*
         * agregar pagos
         **/

        Pago pago1 = PagoBuilder(34.1, contrato, sistema);
        Pago pago2 = PagoBuilder(41.4, contrato, sistema);
        Pago pago3 = PagoBuilder(37.4, contrato1, sistema);

        /** Se han agregado objetos
         donde se escribe el builder y con el builder se van añadiendo cada parametro
         con ese parametro termina en .build

         */

        //the faker
        Locale locale = new Locale("es-CL");
        FakeValuesService fvs = new FakeValuesService();
        Faker faker = new Faker(locale);

        //faker
        for (int i = 0; i < 1000; i++){

            Persona persona = null;
            try {
                persona = Persona.builder().rut(faker.bothify("########-#")).nombre(faker.name().firstName())
                        .apellidos(faker.name().lastName()).email(faker.bothify("????##@gmail.com"))
                        .telefono(faker.bothify("+569########")).build();
            } catch (IllegalDomainException e) {
                throw new RuntimeException(e);
            }

            sistema.getDB().save(persona);

        }
    }

}
