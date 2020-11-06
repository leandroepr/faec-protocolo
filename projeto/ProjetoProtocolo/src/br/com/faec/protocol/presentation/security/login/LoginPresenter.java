package br.com.faec.protocol.presentation.security.login;

import br.com.faec.protocol.domain.exception.security.LoginException;
import br.com.faec.protocol.domain.usecases.security.login.LoginRequest;
import br.com.faec.protocol.domain.usecases.security.login.LoginResponse;
import br.com.faec.protocol.domain.usecases.security.login.LoginUseCase;

/**
 *
 * @author leandroreis
 */
public class LoginPresenter {

    private final LoginView view;
    private final LoginUseCase usecase;
    private final Callback<LoginResponse> onLogin;

    public LoginPresenter(LoginView view, LoginUseCase usecase, Callback<LoginResponse> onLogin) {
        this.view = view;
        this.usecase = usecase;
        this.onLogin = onLogin;

        view.setPresenter(this);
    }

    public void btnLoginPerformed() {
        var username = view.getUsername();
        var password = view.getPassword();

        var request = new LoginRequest(username, password);
        try {
            var response = usecase.login(request);
            onLogin.call(response);
        } catch (LoginException ex) {
            view.showErrorMessage("Usuário ou senha invalido!");
            System.out.println(ex);
        }
    }
}
