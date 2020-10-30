package br.com.faec.protocol;

import br.com.faec.protocol.presentation.security.login.LoginConsole;

/**
 *
 * @author leandroreis
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable login = new LoginConsole();
        login.run();        
    }
    
}
