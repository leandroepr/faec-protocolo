package presentation.security.login;

import domain.exception.security.LoginException;
import domain.exception.security.RepositoryException;
import domain.usecases.security.login.LoginRequest;
import domain.usecases.security.login.LoginResponse;
import domain.usecases.security.login.LoginUseCase;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String username = view.getUsername();
        String password = view.getPassword();

        LoginRequest request = new LoginRequest(username, password);
        try {
            LoginResponse response = usecase.login(request);
            onLogin.call(response);
        } catch (LoginException ex) {
            view.showErrorMessage("Usuário ou senha invalido!");
            System.out.println(ex);
        } catch (RepositoryException ex) {
            view.showErrorMessage("Ocorreu um erro na aplicação!");
            System.err.printf("Repository: %s\nMessage: %s", ex.getRepositoryName(), ex.getMessage());
        }
    }
}
