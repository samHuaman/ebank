package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "FEE_STATUS")
public class FeeStatus implements Serializable {
	
	@Id
	@Column(name = "status_id")
	private Integer status_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "alias", nullable = true)
	private String alias;

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
