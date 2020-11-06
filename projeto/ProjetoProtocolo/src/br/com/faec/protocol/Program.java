package br.com.faec.protocol;

import br.com.faec.protocol.domain.entities.profile.Person;
import br.com.faec.protocol.domain.entities.security.Profile;
import br.com.faec.protocol.domain.entities.security.User;
import br.com.faec.protocol.domain.gateways.People;
import br.com.faec.protocol.domain.gateways.Users;
import br.com.faec.protocol.domain.usecases.security.login.LoginInteractor;
import br.com.faec.protocol.domain.usecases.security.login.LoginResponse;
import br.com.faec.protocol.presentation.security.login.Callback;
import br.com.faec.protocol.presentation.security.login.LoginForm;
import br.com.faec.protocol.presentation.security.login.LoginPresenter;

/**
 *
 * @author leandroreis
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Users fakeUsers = new Users() {
            @Override
            public User getUserByUsername(String username) {
                if (!username.equalsIgnoreCase(username)) {
                    return null;
                }

                var user = new User();
                user.setId(1);
                user.setLogin("lreis");
                user.setPassword("senha123");
                var profile = new Profile();
                profile.setId(1);
                profile.setName("admin");
                profile.setDisplayName("Administrador");
                user.setProfile(profile);

                return user;
            }

        };

        People fakePeople = new People() {
            @Override
            public Person getPersonById(int personId) {
                Person person = new Person();
                person.setName("Leandro Reis");
                return person;
            }
        };

        LoginInteractor interactor = new LoginInteractor(fakeUsers, fakePeople);

        LoginForm view = new LoginForm();
        Callback<LoginResponse> onLoginSuccess = new Callback<LoginResponse>() {
            @Override
            public void call(LoginResponse param) {
                System.out.println("SUCESSO NO LOGIN");
                System.out.println("ENCAMINHAR PARA MAIN");
                System.out.println(param);
                view.setVisible(false);
            }
        };
        LoginPresenter presenter = new LoginPresenter(view, interactor, onLoginSuccess);
        view.setVisible(true);

    }

}
