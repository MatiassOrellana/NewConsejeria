package cl.ucn.disc.as.Services;

import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@Slf4j
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
        this.database.save(edificio);
        return edificio;
    }

    @Override
    public Persona addPersona(@NotNull Persona persona) {
        this.database.save(persona);
        return persona;
    }

    @Override
    public Depto addDepto(@NotNull Depto departamento,@NotNull Long idEdificio) {
        /**added vinculation with depto and edificio*/
        departamento.setIDEdificio(idEdificio);
        /**save in the database*/
        this.database.save(departamento);
        return departamento;
    }

    @Override
    public Contrato addContrato(@NotNull Long dueñoID, @NotNull Long departamentoID, @NotNull Contrato contrato) {
        /**added vinculation with depto and contrato*/
        contrato.setDeptoID(departamentoID);
        /**added vinculation with depto and dueño*/
        contrato.setDueñoID(dueñoID);
        /**save in the database*/
        this.database.save(contrato);
        return contrato;
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Long contratoID) {
        /**added vinculation with pago and contrato*/
        pago.setContratoID(contratoID);
        /**save in the database*/
        this.database.save(pago);
        return pago;
    }
}
