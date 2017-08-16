package pe.openebusiness.ebank.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
public class Schedule implements Serializable {
	
	@Id
	@Column(name = "schedule_id")
	private Integer schedule_id;
	
	@Column(name = "schedule_number", nullable = false)
	private Integer schedule_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "registration_date", nullable = false)
	private Date registration_date;

	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}

	public Integer getSchedule_number() {
		return schedule_number;
	}

	public void setSchedule_number(Integer schedule_number) {
		this.schedule_number = schedule_number;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

}
