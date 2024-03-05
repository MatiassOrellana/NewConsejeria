package cl.ucn.disc.as.exceptions;

import javax.persistence.PersistenceException;

public class SystemException extends RuntimeException{

    public SystemException(String message, PersistenceException ex){
        super(message, ex);
    }

}
