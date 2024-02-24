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
    @NotNull
    private Date fechaDeContrato;

    /**
     * The Dueño.
     */
    @NotNull
    private Long dueñoID;

    /**
     * The depto, the depto can or not have a contract.
     */

    @NotNull
    private Long deptoID;

    /**
     * The Pagos.
     */
    @NotNull
    private List<Pago> pagos;

}
