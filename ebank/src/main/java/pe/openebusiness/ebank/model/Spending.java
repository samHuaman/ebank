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
@Table(name = "SPENDING")
public class Spending implements Serializable {
	
	@Id
	@Column(name = "spending_id")
	private Integer spending_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "spending_type_id", nullable = false)
	private SpendingType spendingType;
	
	@Column(name = "spending_amount")
	private Double spending_amount;
	
	@Column(name = "registration_date")
	private Date registration_date;

	public Integer getSpending_id() {
		return spending_id;
	}

	public void setSpending_id(Integer spending_id) {
		this.spending_id = spending_id;
	}

	public SpendingType getSpendingType() {
		return spendingType;
	}

	public void setSpendingType(SpendingType spendingType) {
		this.spendingType = spendingType;
	}

	public Double getSpending_amount() {
		return spending_amount;
	}

	public void setSpending_amount(Double spending_amount) {
		this.spending_amount = spending_amount;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

}
