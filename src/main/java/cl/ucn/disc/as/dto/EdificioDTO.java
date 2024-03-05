package cl.ucn.disc.as.dto;

import cl.ucn.disc.as.model.Depto;
import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class EdificioDTO {

    /**
     * The Nombre.
     */
    private String nombre;

    /**
     * The Direccion.
     */
    private String direccion;


}
