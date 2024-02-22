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
    @NonNull
    private String rut;

    /**
     * The Nombre.
     */
    @NonNull
    private String nombre;

    /**
     * The Apellidos.
     */
    @NonNull
    private String apellidos;

    /**
     * The Email.
     */
    @NonNull
    private String email;

    /**
     * The Telefono.
     */
    @NonNull
    private String telefono;

    /**
     * The Tipo.
     * 1 = dueño
     * 2 = otro
     */

    @NonNull
    private int tipo;

    /**
     * The Contrato
     */
    @NonNull
    private List<Contrato> contratos;

}
