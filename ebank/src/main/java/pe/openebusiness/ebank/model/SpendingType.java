<<<<<<< HEAD
package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SPENDING_TYPE")
public class SpendingType implements Serializable {
	
	@Id
	@GeneratedValue(generator = "spending_type_seq")
	@SequenceGenerator(name = "spending_type_seq", sequenceName = "SPENDING_TYPE_SEQ", allocationSize = 1)
	@Column(name = "type_id")
	private Integer type_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "short_description", nullable = true)
	private String short_description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@Column(name = "min_amount")
	private Double min_amount;
	
	@Column(name = "max_amount")
	private Double max_amount;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id")
	private SpendingGroupType groupType;

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(Double min_amount) {
		this.min_amount = min_amount;
	}

	public Double getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(Double max_amount) {
		this.max_amount = max_amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SpendingGroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(SpendingGroupType groupType) {
		this.groupType = groupType;
	}

}
=======
package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "SPENDING_TYPE")
public class SpendingType implements Serializable {
	
	@Id
	@GeneratedValue(generator = "spending_type_seq")
	@SequenceGenerator(name = "spending_type_seq", sequenceName = "SPENDING_TYPE_SEQ", allocationSize = 1)
	@Column(name = "type_id")
	private Integer type_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "short_description", nullable = true)
	private String short_description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@Column(name = "min_amount")
	private Double min_amount;
	
	@Column(name = "max_amount")
	private Double max_amount;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id")
	private SpendingGroupType groupType;

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(Double min_amount) {
		this.min_amount = min_amount;
	}

	public Double getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(Double max_amount) {
		this.max_amount = max_amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public SpendingGroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(SpendingGroupType groupType) {
		this.groupType = groupType;
	}

}
>>>>>>> 6003be1fbe66d8959aeeda46b4aefc3305e5cd4f
