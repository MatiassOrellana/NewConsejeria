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
    public Depto addDepto(@NotNull Depto departamento,@NotNull Edificio edificio) {
        departamento.setEdificio(edificio);
        this.database.save(departamento);
        return departamento;
    }

    @Override
    public Depto addDepto(@NotNull Depto departamento,@NotNull Long idEdificio) {
        departamento.setIDEdificio(idEdificio);
        this.database.save(departamento);
        return departamento;
    }

    @Override
    public Contrato addContrato(@NotNull Persona dueño, @NotNull Depto departamento, @NotNull Contrato contrato) {
        departamento.setContrato(contrato);
        contrato.setDueño(dueño);
        this.database.save(contrato);
        return contrato;
    }

    @Override
    public Contrato addContrato(@NotNull Long dueñoID, @NotNull Depto departamento, @NotNull Contrato contrato) {
        departamento.setContratoID(contrato.getId());
        contrato.setDueñoID(dueñoID);
        this.database.save(contrato);
        return contrato;
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Contrato contrato) {
        pago.setContrato(contrato);
        this.database.save(pago);
        return pago;
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Long contratoID) {
        pago.setContratoID(contratoID);
        this.database.save(pago);
        return pago;
    }
}