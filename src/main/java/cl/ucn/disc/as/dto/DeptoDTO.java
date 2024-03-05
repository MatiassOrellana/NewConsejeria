package cl.ucn.disc.as.dto;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeptoDTO {

    /**You want merge the numbers, not add*/
    /**
     * The Numero (String).
     */
    private String numero;

    /**
     * The Piso (String).
     */
    private String piso;


}
