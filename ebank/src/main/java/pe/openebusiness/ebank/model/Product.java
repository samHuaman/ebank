package pe.openebusiness.ebank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	@Id
	@GeneratedValue(generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	@Column(name = "product_id")
	private Integer product_id;

	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "short_description", nullable = true)
	private String short_description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_type_id")
	private ProductType productType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "principal_currency")
	private Currency principalCurrency;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "secundary_currency")
	private Currency secundaryCurrency;

	@Column(name = "validity_start", nullable = true)
	private Date validity_start;

	@Column(name = "validity_end", nullable = true)
	private Date validity_end;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCT_PLAN", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "product_id") }, inverseJoinColumns = {
					@JoinColumn(name = "plan_id", referencedColumnName = "plan_id") })
	private Set<Plan> plans = new HashSet<Plan>();

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Currency getPrincipalCurrency() {
		return principalCurrency;
	}

	public void setPrincipalCurrency(Currency principalCurrency) {
		this.principalCurrency = principalCurrency;
	}

	public Currency getSecundaryCurrency() {
		return secundaryCurrency;
	}

	public void setSecundaryCurrency(Currency secundaryCurrency) {
		this.secundaryCurrency = secundaryCurrency;
	}

	public Date getValidity_start() {
		return validity_start;
	}

	public void setValidity_start(Date validity_start) {
		this.validity_start = validity_start;
	}

	public Date getValidity_end() {
		return validity_end;
	}

	public void setValidity_end(Date validity_end) {
		this.validity_end = validity_end;
	}

	public Set<Plan> getPlans() {
		return plans;
	}

	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}

}
