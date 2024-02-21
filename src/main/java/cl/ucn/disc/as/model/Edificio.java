package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.List;

/**
 * The Edificio class.
 *
 * @author Matias Orellana.
 */
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Edificio extends BaseModel {

    /**
     * The Nombre.
     */
    @NotNull
    private String nombre;

    /**
     * The Direccion.
     */
    @NotNull
    private String direccion;

    /**
     * The Edificios.
     */
    @NotNull
    private List<Edificio> edificios;

}
