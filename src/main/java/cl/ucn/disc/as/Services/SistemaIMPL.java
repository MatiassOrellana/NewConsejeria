package cl.ucn.disc.as.Services;

import cl.ucn.disc.as.exceptions.SystemException;
import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import io.ebean.PersistenceIOException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

import lombok.*;


@Slf4j
@Getter
@Setter
public class SistemaIMPL implements Sistema{

    private List<Contrato> contratos;

    private List<Pago> pagos;

    private List<Persona> personas;

    private List<Depto> deptos;

    private List<Edificio> edificios;

    /**
     * The database
     */
    private final Database database;

    public SistemaIMPL(Database database) {
        this.database = database;
    }

    @Override
    public Edificio addEdificio(@NotNull Edificio edificio) {

        try{

            this.database.save(edificio);
            return edificio;


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un edificio", ex);
        }
    }

    @Override
    public Persona addPersona(@NotNull Persona persona) {

        try{

            this.database.save(persona);
            return persona;


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar una persona", ex);
        }
    }

    @Override
    public Depto addDepto(@NotNull Depto departamento,@NotNull Long idEdificio) {

        try{

            /**added vinculation with depto and edificio*/
            departamento.setIDEdificio(idEdificio);
            /**save in the database*/
            this.database.save(departamento);
            return departamento;


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }
    }

    @Override
    public Depto addDepto(Depto departamento, Edificio edificio) {

        try{

            /**added vinculation with depto and edificio*/
            departamento.setIDEdificio(edificio.getId());
            /**save in the database*/
            this.database.save(departamento);
            return departamento;


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un departamento", ex);
        }
    }

    @Override
    public Contrato addContrato(@NotNull Long dueñoID, @NotNull Long departamentoID, @NotNull Contrato contrato) {

        try{

            /**added vinculation with depto and contrato*/
            contrato.setDeptoID(departamentoID);
            /**added vinculation with depto and dueño*/
            contrato.setDueñoID(dueñoID);
            /**save in the database*/
            this.database.save(contrato);
            return contrato;


        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un contrato", ex);
        }
    }

    @Override
    public Contrato addContrato(Persona dueño, Depto departamento, Contrato contrato) {

        try{

            /**added vinculation with depto and contrato*/
            contrato.setDeptoID(departamento.getId());
            /**added vinculation with depto and dueño*/
            contrato.setDueñoID(dueño.getId());
            /**save in the database*/
            this.database.save(contrato);
            return contrato;

        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un contrato", ex);
        }
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Long contratoID) {
        try{

            /**added vinculation with pago and contrato*/
            pago.setContratoID(contratoID);
            /**save in the database*/
            this.database.save(pago);
            return pago;

        } catch (PersistenceIOException ex) {//el persistence ocurre en cualquier lenguaje

            //Todo: save the exception
            log.error("Error", ex);
            //camino que no debe ocurrir nunca
            throw new SystemException("error al agregar un contrato", ex);
        }
    }

    @Override
    public List<Persona> getPersonasByDB() {
        //TODO: Implement offset and max rows
        return database.find(Persona.class).findList();
    }

    @Override
    public List<Depto> getDeptosByDB() {
        //TODO: Implement offset and max rows
        return database.find(Depto.class).findList();
    }

    @Override
    public Database getDB() {
        return database;
    }
}
