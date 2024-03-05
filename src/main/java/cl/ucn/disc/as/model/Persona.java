/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.model;

import cl.ucn.disc.as.exceptions.IllegalDomainException;
import cl.ucn.disc.as.validations.ValidationUtils;
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

    public static class PersonaBuilder {
        /**
         * @return persona
         */
        public Persona build() throws IllegalDomainException {

            //Se agrego la validadcion del rut
            //validate the rut
            if (!ValidationUtils.isRutValid(this.rut)) {

                //se debe noticar de esa excepcion
                throw new IllegalDomainException("rut no valido: " + this.rut);
                //esa excepcion lo creamos en la carpeta almacenada en exceptions
                //y esa carpeta se creo manualmente

            }
            //validar correo electronico
            if ((!ValidationUtils.isEmailValid(this.email))) {
                throw new IllegalDomainException("Email no valido");
                //tanto para email , como para rut
            }

            //Todo: Agregar resto de validaciones
            return new Persona(
                    this.rut,
                    this.nombre,
                    this.apellidos,
                    this.email,
                    this.telefono
            );
        }
    }

}
