package pl.altkom.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.altkom.dao.HolidaysDAO;
import pl.altkom.model.HolidayBean;

@RequestScoped
@Named("holidaysManager")
public class HolidaysManagerBean implements Serializable {

    private HolidayBean holiday = new HolidayBean();
    
    @Inject
    private AuthenticationBean authBean;

    @PostConstruct
    public void init() {
        holiday.setLogin(authBean.getLogin());
    }

    @Inject
    private HolidaysDAO dao;

    public String saveHoliday() {
        dao.saveHoliday(holiday);
        return "addHoliday?faces-redirect=true";
    }

    public List<HolidayBean> getHolidays() {
        return dao.getHolidays(holiday.getLogin());
    }

    public HolidayBean getHoliday() {
        return holiday;
    }

    public void setHoliday(HolidayBean holiday) {
        this.holiday = holiday;
    }

}
