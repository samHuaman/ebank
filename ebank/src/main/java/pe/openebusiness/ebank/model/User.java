package pe.openebusiness.ebank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "UUSER")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", allocationSize = 1	)
	@Column(name = "user_id")
	private Integer user_id;
	
	@NotEmpty
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@NotEmpty
	@Column(name = "ppassword", nullable = false)
	private String password;
	
	@NotNull
	@Column(name = "enabled", nullable = false)
	private Integer enabled;

	@Column(name = "enabled_commentary", nullable = true)
	private String enabled_commentary;
	
	@Column(name = "user_expired_date", nullable = true)
	private Date user_expired_date;
	
	@Column(name = "credentials_expired_date", nullable = true)
	private Date credentials_expired_date;
	
	@Column(name = "end_lock_date", nullable = true)
	private Date end_lock_date;
	
	@NotEmpty
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "email_confirmed", nullable = false)
	private Integer email_confirmed;
	
	@Column(name = "firstname", nullable = true)
	private String firstname;
	
	@Column(name = "lastname", nullable = true)
	private String lastname;
	
	@Column(name = "days_enabled")
	private Integer days_enabled;
	
	@NotNull
	@Column(name = "failed_attempts", nullable = false)
	private Integer failed_attempts;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "user_id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}

	public Date getUser_expired_date() {
		return user_expired_date;
	}

	public void setUser_expired_date(Date user_expired_date) {
		this.user_expired_date = user_expired_date;
	}

	public Date getCredentials_expired_date() {
		return credentials_expired_date;
	}

	public void setCredentials_expired_date(Date credentials_expired_date) {
		this.credentials_expired_date = credentials_expired_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Date getEnd_lock_date() {
		return end_lock_date;
	}

	public void setEnd_lock_date(Date end_lock_date) {
		this.end_lock_date = end_lock_date;
	}

	public Integer getEmail_confirmed() {
		return email_confirmed;
	}

	public void setEmail_confirmed(Integer email_confirmed) {
		this.email_confirmed = email_confirmed;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getDays_enabled() {
		return days_enabled;
	}

	public void setDays_enabled(Integer days_enabled) {
		this.days_enabled = days_enabled;
	}

	public Integer getFailed_attempts() {
		return failed_attempts;
	}

	public void setFailed_attempts(Integer failed_attempts) {
		this.failed_attempts = failed_attempts;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEnabled_commentary() {return enabled_commentary;}

	public void setEnabled_commentary(String enabled_commentary) {this.enabled_commentary = enabled_commentary;}


}
