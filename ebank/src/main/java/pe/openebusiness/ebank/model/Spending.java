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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@Column(name = "spending_amount")
	private Double spending_amount;
	
	@Column(name = "registration_date")
	private Date registration_date;
	
	@Column(name = "status", nullable = false)
	private Integer status;

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

<<<<<<< HEAD
}
<<<<<<< HEAD
=======
}
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
=======
>>>>>>> 267acc236f5ac5026c56737813825b0d5a238d81
