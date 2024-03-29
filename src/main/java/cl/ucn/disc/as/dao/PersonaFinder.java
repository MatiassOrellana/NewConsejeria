/*
 * Copyright (c) 2023. Arquitectura de Sistemas, DISC, UCN.
 */

package cl.ucn.disc.as.dao;

import cl.ucn.disc.as.model.Persona;
//import cl.ucn.disc.as.model.query.QPersona;
import io.ebean.Finder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * The Finder of Persona.
 *
 * @author Diego Urrutia-Astorga.
 */
public class PersonaFinder extends Finder<Long, Persona> {


    /**
     * The Constructor.
     */
    public PersonaFinder() {
        super(Persona.class);
    }

    /**
     * Find a Persona by rut.
     *
     * @param rut to use.
     * @return the Persona.
     */
    /**
    public Optional<Persona> byRut(@NotNull Integer rut) {
        return new QPersona().rut.eq(rut).findOneOrEmpty();
    }*/
}
