package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;
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
public class Contrato extends BaseModel{

    /**
     * The Fecha de contratacion.
     */
    @NonNull
    private Date fechaDeContrato;

    /**
     * The Dueño.
     */
    @NonNull
    private Long dueñoID;

    /**
     * The Pagos.
     */
    @NonNull
    private List<Pago> pagos;

    /**
     * The Deptos.
     */
    @NonNull
    private List<Depto> deptos;

}
