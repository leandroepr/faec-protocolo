package domain.usecases.security.login;

import domain.exception.security.LoginException;
import domain.exception.security.RepositoryException;

/**
 *
 * @author leandroreis
 */
public interface LoginUseCase {

    LoginResponse login(LoginRequest params) throws LoginException, RepositoryException;
}
