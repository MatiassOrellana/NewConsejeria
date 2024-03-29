package cl.ucn.disc.as.model;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.joda.time.DateTime;

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
    @NotNull
    private DateTime fecha;

    /**
     * The Monto.
     */
    @NotNull
    private Double monto;

    /**
     * The Contrato ID.
     */
    @NotNull
    private Long contratoID;


}
