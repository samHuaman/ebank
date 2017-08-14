package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ECONOMIC_ACTIVITY")
public class EconomicActivity implements Serializable {

	@Id
	@Column(name = "activity_id")
	private Integer activity_id;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;

	public Integer getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
