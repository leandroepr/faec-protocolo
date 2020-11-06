package br.com.faec.protocol.domain.usecases.security.login;

import br.com.faec.protocol.domain.entities.profile.Person;
import br.com.faec.protocol.domain.entities.security.User;
import br.com.faec.protocol.domain.exception.security.LoginException;
import br.com.faec.protocol.domain.gateways.People;
import br.com.faec.protocol.domain.gateways.Users;

/**
 *
 * @author leandroreis
 */
public class LoginInteractor implements LoginUseCase {

    private final Users users;
    private final People people;

    public LoginInteractor(Users users, People people) {
        this.users = users;
        this.people = people;
    }

    @Override
    public LoginResponse login(LoginRequest params) throws LoginException {
        User user = users.getUserByUsername(params.getUsername());
        boolean userNotFound = user == null;
        if (userNotFound) {
            throw new LoginException();
        }
        @SuppressWarnings("null")
        boolean wrongPassword = !user.validatePassword(params.getPassword());
        if (wrongPassword) {
            throw new LoginException();
        }
        LoginResponse response = new LoginResponse();
        Person person = people.getPersonById(user.getId());
        response.setUsername(user.getLogin());
        response.setName(person.getName());
        response.setProfile(user.getProfile().getName());
        return response;
    }

}
