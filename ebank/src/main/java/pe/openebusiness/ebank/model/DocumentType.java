package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "DOCUMENT_TYPE")
public class DocumentType implements Serializable {
	
	@Id
	@Column(name = "type_id")
	private Integer type_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "short_description", nullable = true)
	private String short_description;

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

}
