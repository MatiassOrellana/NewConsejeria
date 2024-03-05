package cl.ucn.disc.as.dto;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

@Getter
@AllArgsConstructor
public class ContratoDTO {

    /**
     * The Fecha de contratacion.
     */
    private DateTime fechaDeContrato;

}
