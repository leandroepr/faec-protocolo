package br.com.faec.protocol.presentation.security.login;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author leandroreis
 */
 
public class LoginBean{

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    private String username;
    private String password;

    public LoginBean() {
    }

    
    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldValue = this.username;        
        this.username = username;
        pcs.firePropertyChange("username", oldValue, username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
    pcs.addPropertyChangeListener(pcl);
  }

  public void removePropertyChangeListener(PropertyChangeListener pcl) {
    pcs.removePropertyChangeListener(pcl);
  }

    @Override
    public String toString() {
        return "LoginBean{" + "username=" + username + ", password=" + password + '}';
    }

}
