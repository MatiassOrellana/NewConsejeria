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
    @NonNull
    private String nombre;

    /**
     * The Direccion.
     */
    @NonNull
    private String direccion;

    /**
     * The Edificios.
     */
    @NonNull
    private List<Depto> deptos;

}
