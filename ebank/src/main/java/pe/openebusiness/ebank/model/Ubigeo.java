package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "UBIGEO")
public class Ubigeo implements Serializable {
	
	@Id
	@Column(name = "ubigeo_id")
	private Integer ubigeo_id;
	
	@Column(name = "ubigeo_code", nullable = false, unique = true)
	private String ubigeo_code;
	
	@Column(name = "department", nullable = false)
	private String department;
	
	@Column(name = "province", nullable = false)
	private String province;
	
	@Column(name = "district", nullable = false)
	private String district;
	
	@Formula(value = "ubigeo_code || '-' || department || ', ' || province || ', ' || district")
	private String full_description;

	public String getFull_description() {
		return full_description;
	}

	public void setFull_description(String full_description) {
		this.full_description = full_description;
	}

	public Integer getUbigeo_id() {
		return ubigeo_id;
	}

	public void setUbigeo_id(Integer ubigeo_id) {
		this.ubigeo_id = ubigeo_id;
	}

	public String getUbigeo_code() {
		return ubigeo_code;
	}

	public void setUbigeo_code(String ubigeo_code) {
		this.ubigeo_code = ubigeo_code;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
