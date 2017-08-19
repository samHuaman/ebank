package pe.openebusiness.ebank.filter;

import java.io.Serializable;
import java.util.Date;

public class FeeFilter implements Serializable {
	
	private Date scheduleRegistrationDate;

	public Date getScheduleRegistrationDate() {
		return scheduleRegistrationDate;
	}

	public void setScheduleRegistrationDate(Date scheduleRegistrationDate) {
		this.scheduleRegistrationDate = scheduleRegistrationDate;
	}

}
