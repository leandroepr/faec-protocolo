package domain.exception.security;

/**
 *
 * @author Administrador
 */
public class RepositoryException extends Exception {

    private final String repositoryName;
    private final String message;

    public RepositoryException(String repositoryName, String message) {
        this.repositoryName = repositoryName;
        this.message = message;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getMessage() {
        return message;
    }
}
