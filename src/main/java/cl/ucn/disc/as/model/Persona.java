/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.List;

/**
 * The Persona class.
 *
 * @author Diego Urrutia-Astorga.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Persona extends BaseModel {

    /**
     * The RUT.
     */
    @NotNull
    private String rut;

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Apellidos.
     */
    @NotNull
    private String apellidos;

    /**
     * The Email.
     */
    @NotNull
    private String email;

    /**
     * The Telefono.
     */
    @NotNull
    private String telefono;

    /**
     * The Contrato
     */
    @NotNull
    private List<Contrato> contratos;

}
