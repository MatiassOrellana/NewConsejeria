package cl.ucn.disc.as.dto;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonaDTO {

    /**
     * The RUT.
     */
    private String rut;

    /**
     * The Nombre.
     */
    private String nombre;

    /**
     * The Apellidos.
     */
    private String apellidos;

    /**
     * The Email.
     */
    private String email;

    /**
     * The Telefono.
     */
    private String telefono;

}
