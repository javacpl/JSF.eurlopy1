package pl.altkom.dao;

import java.util.List;
import javax.ejb.Local;
import pl.altkom.model.UserBean;

@Local
public interface UsersDAO {

    public UserBean getUser(String login);

    public void saveUser(UserBean user);

    public List<UserBean> getUsers();

}
