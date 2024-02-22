package cl.ucn.disc.as.model;

import io.avaje.lang.Nullable;
import io.ebean.annotation.NotNull;
import io.ebeaninternal.server.util.Str;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Depto extends BaseModel{


    /**You want merge the numbers, not add*/
    /**
     * The Numero (String).
     */
    @NonNull
    private String numero;

    /**
     * The Piso (String).
     */
    @NonNull
    private String piso;

    /**
     * The Contrato, the depto can or not have a contract.
     */

    @Nullable
    private Long contratoID;

    /**
     * The Edificio ID.
     */
    @NonNull
    private Long IDEdificio;


}
