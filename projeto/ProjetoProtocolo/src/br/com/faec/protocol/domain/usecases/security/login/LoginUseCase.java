package br.com.faec.protocol.domain.usecases.security.login;

import br.com.faec.protocol.domain.exception.security.LoginException;

/**
 *
 * @author leandroreis
 */
public interface LoginUseCase{
    LoginResponse login(LoginRequest params) throws LoginException;
}
