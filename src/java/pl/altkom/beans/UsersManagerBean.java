package pl.altkom.beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.altkom.dao.UsersDAO;
import pl.altkom.model.UserBean;

@RequestScoped
@Named("usersManager")
public class UsersManagerBean implements Serializable {

    private UserBean user = new UserBean();

    @Inject
    private UsersDAO dao;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<UserBean> getUsers() {
        return dao.getUsers();
    }

    public String saveUser() {
        dao.saveUser(user);
        return "adminPage?faces-redirect=true";
    }

}
