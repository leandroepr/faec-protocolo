package br.com.faec.protocol.domain.gateways;

import br.com.faec.protocol.domain.entities.profile.Person;

/**
 *
 * @author leandroreis
 */
public interface People {

    Person getPersonById(int personId);
}
