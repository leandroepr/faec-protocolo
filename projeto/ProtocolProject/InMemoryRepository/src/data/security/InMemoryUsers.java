package data.security;

import domain.entities.security.Profile;
import domain.entities.security.User;
import domain.exception.security.RepositoryException;
import domain.gateways.security.Users;

/**
 *
 * @author Administrador
 */
public class InMemoryUsers implements Users {

    @Override
    public User getUserByUsername(String username) throws RepositoryException {
        if (username.equals("error")) {
            throw new RepositoryException("USERS", "Deu um erro porque eu quiz");
        }
        if (username.equalsIgnoreCase("lreis")) {
            User user = new User();
            user.setId(1);
            user.setLogin("lreis");
            user.setPassword("senha123");
            Profile profile = new Profile();
            profile.setId(1);
            profile.setName("admin");
            profile.setDisplayName("Administrador");
            user.setProfile(profile);

            return user;
        }

        return null;
    }

}
