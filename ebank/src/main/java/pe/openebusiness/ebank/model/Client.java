package pe.openebusiness.ebank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
	
	@Id
	@Column(name = "client_id")
	private Integer client_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_type_id")
	private PersonType personType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "document_type_id")
	private DocumentType documentType;
	
	@NotEmpty
	@Column(name = "document_number", nullable = false, unique = true)
	private String document_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "magnitude_id")
	private Magnitude magnitude;
	
	@Column(name = "taxpayer_id_number", nullable = true, unique = true)
	private String taxpayer_id_number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "economic_activity_id")
	private EconomicActivity economicActivity;
	
	@NotEmpty
	@Column(name = "firstname", nullable = false)
	private String fristname;
	
	@Column(name = "secondname", nullable = true)
	private String secondname;
	
	@Column(name = "lastname_a", nullable = true)
	private String lastname_a;
	
	@Column(name = "lastname_b", nullable = true)
	private String lastname_b;
	
	@Column(name = "married_surname", nullable = true)
	private String married_surname;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gender_id")
	private Gender gender;
	
	@Column(name = "birthdate", nullable = true)
	private Date birthdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nacionality")
	private Country nacionality;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "residence_country")
	private Country residence_country;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "civil_status_id")
	private CivilStatus civilStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employment_situation_id")
	private EmploymentSituation employmentSituation;
		
	@Column(name = "data_protection_act", nullable = false, length = 1)
	private Integer data_protection_act;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
	private Set<ClientAddress> addresses = new HashSet<ClientAddress>();
	
	@JsonIgnore
	@NotEmpty
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
	private Set<ClientContactInformation> contacts = new HashSet<ClientContactInformation>(); 

	public Set<ClientAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<ClientAddress> addresses) {
		this.addresses = addresses;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public String getTaxpayer_id_number() {
		return taxpayer_id_number;
	}

	public void setTaxpayer_id_number(String taxpayer_id_number) {
		this.taxpayer_id_number = taxpayer_id_number;
	}

	public String getFristname() {
		return fristname;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getLastname_a() {
		return lastname_a;
	}

	public void setLastname_a(String lastname_a) {
		this.lastname_a = lastname_a;
	}

	public String getLastname_b() {
		return lastname_b;
	}

	public void setLastname_b(String lastname_b) {
		this.lastname_b = lastname_b;
	}

	public String getMarried_surname() {
		return married_surname;
	}

	public void setMarried_surname(String married_surname) {
		this.married_surname = married_surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getData_protection_act() {
		return data_protection_act;
	}

	public void setData_protection_act(Integer data_protection_act) {
		this.data_protection_act = data_protection_act;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Magnitude getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(Magnitude magnitude) {
		this.magnitude = magnitude;
	}

	public EconomicActivity getEconomicActivity() {
		return economicActivity;
	}

	public void setEconomicActivity(EconomicActivity economicActivity) {
		this.economicActivity = economicActivity;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Country getNacionality() {
		return nacionality;
	}

	public void setNacionality(Country nacionality) {
		this.nacionality = nacionality;
	}

	public Country getResidence_country() {
		return residence_country;
	}

	public void setResidence_country(Country residence_country) {
		this.residence_country = residence_country;
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	public EmploymentSituation getEmploymentSituation() {
		return employmentSituation;
	}

	public void setEmploymentSituation(EmploymentSituation employmentSituation) {
		this.employmentSituation = employmentSituation;
	}

}
