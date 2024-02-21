package cl.ucn.disc.as.Services;

import cl.ucn.disc.as.model.*;
import io.ebean.Database;
import io.ebean.PersistenceIOException;
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

    private final Database database;

    public SistemaIMPL(Database database) {
        this.database = database;
    }

    @Override
    public Edificio addEdificio(Edificio edificio) {
        return null;
    }

    @Override
    public Persona addPersona(Persona persona) {
        return null;
    }

    @Override
    public Depto addDepto(Depto departamento, Edificio edificio) {
        return null;
    }

    @Override
    public Depto addDepto(Depto departamento, Long idEdificio) {
        return null;
    }

    @Override
    public Contrato addContrato(Persona dueño, Depto departamento, Date fechaGastos, Contrato contrato) {
        return null;
    }

    @Override
    public Contrato addContrato(Long dueñoID, Depto departamento, Date fechaGastos, Contrato contrato) {
        return null;
    }

    @Override
    public Pago addPago(Pago pago, Contrato contrato) {
        return null;
    }

    @Override
    public Pago addPago(Pago pago, Long contratoID) {
        return null;
    }
}
