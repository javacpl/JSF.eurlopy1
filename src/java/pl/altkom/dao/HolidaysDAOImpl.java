package pl.altkom.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.altkom.model.HolidayBean;

@Stateless
public class HolidaysDAOImpl implements HolidaysDAO {

    @PersistenceContext(unitName = "JSF.eurlopyPU")
    private EntityManager em;

    @Override
    public void saveHoliday(HolidayBean holidayBean) {
        em.persist(holidayBean);
    }

    @Override
    public List<HolidayBean> getHolidays(String login) {
        return em.createNamedQuery("getHolidaysByLogin", HolidayBean.class)
                .setParameter("login", login)
                .getResultList();
    }
}
