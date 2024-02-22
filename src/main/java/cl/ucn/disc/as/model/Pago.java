package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

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
public class Pago extends BaseModel {

    /**
     * The fecha.
     */
    @NonNull
    private Date fecha;

    /**
     * The Monto.
     */
    @NonNull
    private Double monto;

    /**
     * The Contrato ID.
     */
    @NonNull
    private Long contratoID;


}
