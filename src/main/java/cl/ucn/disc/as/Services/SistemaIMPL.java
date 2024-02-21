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
        return null;
    }

    @Override
    public Persona addPersona(@NotNull Persona persona) {
        return null;
    }

    @Override
    public Depto addDepto(@NotNull Depto departamento,@NotNull Edificio edificio) {
        return null;
    }

    @Override
    public Depto addDepto(@NotNull Depto departamento,@NotNull Long idEdificio) {
        return null;
    }

    @Override
    public Contrato addContrato(@NotNull Persona dueño, @NotNull Depto departamento, @NotNull Contrato contrato) {
        return null;
    }

    @Override
    public Contrato addContrato(@NotNull Long dueñoID, @NotNull Depto departamento, @NotNull Contrato contrato) {
        return null;
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Contrato contrato) {
        return null;
    }

    @Override
    public Pago addPago(@NotNull Pago pago, @NotNull Long contratoID) {
        return null;
    }
}
