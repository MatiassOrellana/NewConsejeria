package cl.ucn.disc.as.Services;

import cl.ucn.disc.as.model.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public interface Sistema {

    /**
     * @param edificio a agregar
     * @return
     */
    public Edificio addEdificio(Edificio edificio);

    /**
     * @param persona a agregar
     * @return
     */
    public Persona addPersona(Persona persona);

    /**
     * @param departamento a agregar
     * @param edificio a agregar
     * @return
     */
    public Depto addDepto(Depto departamento, Edificio edificio);

    /**
     * @param departamento a agregar
     * @param idEdificio a agregar
     * @return
     */
    public Depto addDepto(Depto departamento, Long idEdificio);

    /**
     * @param dueño a agregar
     * @param departamento a agregar
     * @param contrato a agregar
     * @return
     */
    public Contrato addContrato(Persona dueño, Depto departamento, Contrato contrato);

    /**
     * @param dueñoID a agregar
     * @param departamento a agregar
     * @param contrato a agregar
     * @return
     */
    public Contrato addContrato(Long dueñoID, Depto departamento, Contrato contrato);

    /**
     * @param pago a agregar
     * @param contrato a agregar
     * @return
     */
    public Pago addPago(Pago pago, Contrato contrato);

    /**
     * @param pago a agregar
     * @param contratoID a agregar
     * @return
     */
    public Pago addPago(Pago pago, Long contratoID);

}


