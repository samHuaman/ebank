package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ADDRESS_GROUP_TYPE")
public class AddressGroupType implements Serializable {
	
	@Id
	@Column(name = "group_type_id")
	private Integer group_type_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;

	public Integer getGroup_type_id() {
		return group_type_id;
	}

	public void setGroup_type_id(Integer group_type_id) {
		this.group_type_id = group_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
