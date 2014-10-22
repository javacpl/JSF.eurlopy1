package pl.altkom.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.altkom.model.UserBean;

@Stateless
public class UsersDAOImpl implements UsersDAO {

    @PersistenceContext(unitName = "JSF.eurlopyPU")
    private EntityManager em;

    @Override
    public UserBean getUser(String login) {
       return  em.createNamedQuery("getUserByLogin", UserBean.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public void saveUser(UserBean user) {
        em.persist(user);
    }

    @Override
    public List<UserBean> getUsers() {
        return em.createNamedQuery("getAllUsers", UserBean.class)
                .getResultList();
    }
}
