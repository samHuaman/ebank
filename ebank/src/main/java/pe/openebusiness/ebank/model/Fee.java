<<<<<<< HEAD
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
@Table(name = "FEE")
public class Fee implements Serializable {
	
	@Id
	@Column(name = "fee_id")
	private Integer fee_id;
	
	@Column(name = "fee_number", nullable = false)
	private Integer fee_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;
	
	@Column(name = "expiration_date")
	private Date expiration_date;
	
	@Column(name = "capital")
	private Double capital;
	
	@Column(name = "compensatory_interest")
	private Double compensatory_interest;
	
	@Column(name = "arrears_interest")
	private Double arrears_interest;
	
	@Column(name = "monthly_commissions")
	private Integer monthly_commissions;
	
	@Column(name = "total_fee")
	private Double total_fee;
	
	@Column(name = "disgrace_insurance")
	private Double disgrace_insurance;
	
	@Column(name = "other_insurance")
	private Double other_insurance;
	
	@Column(name = "total_pay")
	private Double total_pay;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", nullable = false)
	private FeeStatus feeStatus;
	
	public Integer getFee_id() {
		return fee_id;
	}

	public void setFee_id(Integer fee_id) {
		this.fee_id = fee_id;
	}

	public Integer getFee_number() {
		return fee_number;
	}

	public void setFee_number(Integer fee_number) {
		this.fee_number = fee_number;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Double getCompensatory_interest() {
		return compensatory_interest;
	}

	public void setCompensatory_interest(Double compensatory_interest) {
		this.compensatory_interest = compensatory_interest;
	}

	public Double getArrears_interest() {
		return arrears_interest;
	}

	public void setArrears_interest(Double arrears_interest) {
		this.arrears_interest = arrears_interest;
	}

	public Integer getMonthly_commissions() {
		return monthly_commissions;
	}

	public void setMonthly_commissions(Integer monthly_commissions) {
		this.monthly_commissions = monthly_commissions;
	}

	public Double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Double total_fee) {
		this.total_fee = total_fee;
	}

	public Double getDisgrace_insurance() {
		return disgrace_insurance;
	}

	public void setDisgrace_insurance(Double disgrace_insurance) {
		this.disgrace_insurance = disgrace_insurance;
	}

	public Double getOther_insurance() {
		return other_insurance;
	}

	public void setOther_insurance(Double other_insurance) {
		this.other_insurance = other_insurance;
	}

	public Double getTotal_pay() {
		return total_pay;
	}

	public void setTotal_pay(Double total_pay) {
		this.total_pay = total_pay;
	}

	public FeeStatus getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(FeeStatus feeStatus) {
		this.feeStatus = feeStatus;
	}

}
=======
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
@Table(name = "FEE")
public class Fee implements Serializable {
	
	@Id
	@Column(name = "fee_id")
	private Integer fee_id;
	
	@Column(name = "fee_number", nullable = false)
	private Integer fee_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id", nullable = false)
	private Schedule schedule;
	
	@Column(name = "expiration_date")
	private Date expiration_date;
	
	@Column(name = "capital")
	private Double capital;
	
	@Column(name = "compensatory_interest")
	private Double compensatory_interest;
	
	@Column(name = "arrears_interest")
	private Double arrears_interest;
	
	@Column(name = "monthly_commissions")
	private Integer monthly_commissions;
	
	@Column(name = "total_fee")
	private Double total_fee;
	
	@Column(name = "disgrace_insurance")
	private Double disgrace_insurance;
	
	@Column(name = "other_insurance")
	private Double other_insurance;
	
	@Column(name = "total_pay")
	private Double total_pay;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", nullable = false)
	private FeeStatus feeStatus;
	
	public Integer getFee_id() {
		return fee_id;
	}

	public void setFee_id(Integer fee_id) {
		this.fee_id = fee_id;
	}

	public Integer getFee_number() {
		return fee_number;
	}

	public void setFee_number(Integer fee_number) {
		this.fee_number = fee_number;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Double getCompensatory_interest() {
		return compensatory_interest;
	}

	public void setCompensatory_interest(Double compensatory_interest) {
		this.compensatory_interest = compensatory_interest;
	}

	public Double getArrears_interest() {
		return arrears_interest;
	}

	public void setArrears_interest(Double arrears_interest) {
		this.arrears_interest = arrears_interest;
	}

	public Integer getMonthly_commissions() {
		return monthly_commissions;
	}

	public void setMonthly_commissions(Integer monthly_commissions) {
		this.monthly_commissions = monthly_commissions;
	}

	public Double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Double total_fee) {
		this.total_fee = total_fee;
	}

	public Double getDisgrace_insurance() {
		return disgrace_insurance;
	}

	public void setDisgrace_insurance(Double disgrace_insurance) {
		this.disgrace_insurance = disgrace_insurance;
	}

	public Double getOther_insurance() {
		return other_insurance;
	}

	public void setOther_insurance(Double other_insurance) {
		this.other_insurance = other_insurance;
	}

	public Double getTotal_pay() {
		return total_pay;
	}

	public void setTotal_pay(Double total_pay) {
		this.total_pay = total_pay;
	}

	public FeeStatus getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(FeeStatus feeStatus) {
		this.feeStatus = feeStatus;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
