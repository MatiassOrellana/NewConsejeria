package cl.ucn.disc.as.dto;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

@Getter
@AllArgsConstructor
public class PagoDTO {

    /**
     * The fecha.
     */
    private DateTime fecha;

    /**
     * The Monto.
     */
    private Double monto;

}
