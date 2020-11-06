package br.com.faec.protocol.presentation.security.login;

/**
 *
 * @author leandroreis
 * @param <T> generic type
 */
public interface Callback<T> {

    void call(T param);
}
