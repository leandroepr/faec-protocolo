package br.com.faec.protocol.presentation.security.login;

/**
 *
 * @author leandroreis
 */
public interface LoginView {

    String getUsername();

    String getPassword();

    void showErrorMessage(String message);

    void setPresenter(LoginPresenter presenter);
}
