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

@Entity
@Table(name = "CLIENT_CONTACT_INFORMATION")
public class ClientContactInformation implements Serializable {
	
	@Id
	@GeneratedValue(generator = "client_contact_seq")
	@SequenceGenerator(name = "client_contact_seq", sequenceName = "CLIENT_CONTACT_SEQ", allocationSize = 1	)
	@Column(name = "contact_information_id")
	private Integer contact_information_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "home_phone")
	private String home_phone;
	
	@Column(name = "cellphone")
	private String cellphone;

	public Integer getContact_information_id() {
		return contact_information_id;
	}

	public void setContact_information_id(Integer contact_information_id) {
		this.contact_information_id = contact_information_id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}