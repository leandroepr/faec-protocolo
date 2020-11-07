
import data.profile.InMemoryPeople;
import data.security.InMemoryUsers;
import domain.gateways.profile.People;
import domain.gateways.security.Users;
import presentation.security.login.Callback;
import presentation.security.login.LoginForm;
import presentation.security.login.LoginPresenter;
import domain.usecases.security.login.LoginInteractor;
import domain.usecases.security.login.LoginResponse;

/**
 *
 * @author leandroreis
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Users fakeUsers = new InMemoryUsers();
        People fakePeople = new InMemoryPeople();

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
