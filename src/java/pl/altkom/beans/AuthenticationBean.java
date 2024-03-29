package pl.altkom.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.altkom.dao.UsersDAO;
import pl.altkom.model.UserBean;

@SessionScoped
@Named("authBean")
public class AuthenticationBean implements Serializable {

    private String login;
    private String password;
    private String type;
    private boolean logged;
    private UserBean user;

    @PostConstruct
    public void clear() {
        login  = "";
        password = "";
        type = "";
        logged = false;
        user = null;
    }

    @Inject
    private UsersDAO dao;

    public String tryLogin() {
        logged = false;
        type = null;

        user = dao.getUser(login);
        if ((user != null) && password.equals(user.getPassword())) {
            logged = true;
            type = user.getType();
            return type + "Logged";
        }
        return "loginFailure";
    }

    public String logout() {
        clear();
        return "logout";
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
    
}
