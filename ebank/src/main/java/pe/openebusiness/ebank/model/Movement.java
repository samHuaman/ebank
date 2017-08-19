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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "MOVEMENT")
public class Movement implements Serializable {
	
	@Id
	@Column(name = "movement_id")
	private Integer movement_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movement_type_id")
	private MovementType movementType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operation_type_id")
	private OperationType operationType;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "operation_date")
	private Date operation_date;

	public Integer getMovement_id() {
		return movement_id;
	}

	public void setMovement_id(Integer movement_id) {
		this.movement_id = movement_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public MovementType getMovementType() {
		return movementType;
	}

	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getOperation_date() {
		return operation_date;
	}

	public void setOperation_date(Date operation_date) {
		this.operation_date = operation_date;
	}

}

