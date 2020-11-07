package domain.gateways.security;

import domain.entities.security.User;
import domain.exception.security.RepositoryException;

/**
 *
 * @author leandroreis
 */
public interface Users {

    User getUserByUsername(String username) throws RepositoryException;
}
