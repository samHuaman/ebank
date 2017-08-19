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
@Table(name = "PAYMENT")
public class Payment implements Serializable {
	
	@Id
	@Column(name = "payment_id")
	private Integer payment_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fee_id", nullable = false)
	private Fee fee;
	
	@Column(name = "paid_amount")
	private Double paid_amount;
	
	@Column(name = "transaction_date")
	private Date transaction_date;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Double getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(Double paid_amount) {
		this.paid_amount = paid_amount;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
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
@Table(name = "PAYMENT")
public class Payment implements Serializable {
	
	@Id
	@Column(name = "payment_id")
	private Integer payment_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fee_id", nullable = false)
	private Fee fee;
	
	@Column(name = "paid_amount")
	private Double paid_amount;
	
	@Column(name = "transaction_date")
	private Date transaction_date;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Double getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(Double paid_amount) {
		this.paid_amount = paid_amount;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
