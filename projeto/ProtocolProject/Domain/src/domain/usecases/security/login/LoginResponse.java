package domain.usecases.security.login;

/**
 *
 * @author leandroreis
 */
public class LoginResponse {

    private String name;
    private String username;
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "LoginResponse{" + "name=" + name + ", username=" + username + ", profile=" + profile + '}';
    }

}
