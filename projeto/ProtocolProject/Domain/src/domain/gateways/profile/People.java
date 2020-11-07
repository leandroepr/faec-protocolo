package domain.gateways.profile;

import domain.entities.profile.Person;
import domain.exception.security.RepositoryException;

/**
 *
 * @author leandroreis
 */
public interface People {

    Person getPersonById(int personId) throws RepositoryException;
}
