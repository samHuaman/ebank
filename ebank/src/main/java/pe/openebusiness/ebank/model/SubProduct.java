package pe.openebusiness.ebank.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "SUB_PRODUCT")
public class SubProduct implements Serializable {
	
	@Id
	@GeneratedValue(generator = "subproduct_seq")
	@SequenceGenerator(name = "subproduct_seq", sequenceName = "SUBPRODUCT_SEQ", allocationSize = 1)
	@Column(name = "sub_product_id")
	private Integer sub_product_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "short_description", nullable = true)
	private String short_description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "associated_product")
	private Product product;
	
	@Column(name = "validity_start", nullable = true)
	private Date validity_start;
	
	@Column(name = "validity_end", nullable = true)
	private Date validity_end;

	public Integer getSub_product_id() {
		return sub_product_id;
	}

	public void setSub_product_id(Integer sub_product_id) {
		this.sub_product_id = sub_product_id;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

}
