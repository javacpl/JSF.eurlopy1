package pl.altkom.dao;

import java.util.List;
import javax.ejb.Local;
import pl.altkom.model.HolidayBean;

@Local
public interface HolidaysDAO {

    public void saveHoliday(HolidayBean holidayBean);

    public List<HolidayBean> getHolidays(String login);
}
