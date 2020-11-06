package br.com.faec.protocol.domain.gateways;

import br.com.faec.protocol.domain.entities.security.User;

/**
 *
 * @author leandroreis
 */
public interface Users {
    User getUserByUsername(String username);
}
