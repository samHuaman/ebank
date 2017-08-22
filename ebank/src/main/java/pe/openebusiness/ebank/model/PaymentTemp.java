package pe.openebusiness.ebank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_TEMP")
public class PaymentTemp implements Serializable {
	
	@Id
	@Column(name = "payment_temp_id")
	private Integer payment_temp_id;
	
	@Column(name = "group_id", nullable = false)
	private Integer group_id;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "trust_number")
	private String trust_number;
	
	@Column(name = "id_client")
	private String id_client;
	
	@Column(name = "id_operation")
	private String id_operation;
	
	@Column(name = "product_type")
	private String product_type;
	
	@Column(name = "installment_number")
	private String installment_number;
	
	@Column(name = "principal_payment")
	private String principal_payment;
	
	@Column(name = "interest")
	private String interest;
	
	@Column(name = "arrears")	
	private String arrears;
	
	@Column(name = "pre_payment_fee")
	private String pre_payment_fee;
	
	@Column(name = "pre_payment_fee2")
	private String pre_payment_fee2;
	
	@Column(name = "expenses_on_arrears")
	private String expenses_on_arrears;
	
	@Column(name = "fees_on_arrears")
	private String fees_on_arrears;
	
	@Column(name = "pre_payment_installment_fee")
	private String pre_payment_installment_fee;
	
	@Column(name = "pre_legal_fee")
	private String pre_legal_fee;
	
	@Column(name = "legal_fee")
	private String legal_fee;
	
	@Column(name = "other_expenses")
	private String other_expenses;
	
	@Column(name = "expenses")
	private String expenses;
	
	@Column(name = "upb")
	private String upb;
	
	@Column(name = "process_date1")
	private String process_date1;
	
	@Column(name = "process_date2")
	private String process_date2;
	
	@Column(name = "transaction_code")
	private String transaction_code;
	
	@Column(name = "process_date3")
	private String process_date3;
	
	@Column(name = "legal_date")
	private String legal_date;
	
	@Column(name = "collateral_value")
	private String collateral_value;
	
	@Column(name = "legal_date2")
	private String legal_date2;
	
	@Column(name = "subjective_situation_code")
	private String subjective_situation_code;

	public Integer getPayment_temp_id() {
		return payment_temp_id;
	}

	public void setPayment_temp_id(Integer payment_temp_id) {
		this.payment_temp_id = payment_temp_id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTrust_number() {
		return trust_number;
	}

	public void setTrust_number(String trust_number) {
		this.trust_number = trust_number;
	}

	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public String getId_operation() {
		return id_operation;
	}

	public void setId_operation(String id_operation) {
		this.id_operation = id_operation;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getInstallment_number() {
		return installment_number;
	}

	public void setInstallment_number(String installment_number) {
		this.installment_number = installment_number;
	}

	public String getPrincipal_payment() {
		return principal_payment;
	}

	public void setPrincipal_payment(String principal_payment) {
		this.principal_payment = principal_payment;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getArrears() {
		return arrears;
	}

	public void setArrears(String arrears) {
		this.arrears = arrears;
	}

	public String getPre_payment_fee() {
		return pre_payment_fee;
	}

	public void setPre_payment_fee(String pre_payment_fee) {
		this.pre_payment_fee = pre_payment_fee;
	}

	public String getPre_payment_fee2() {
		return pre_payment_fee2;
	}

	public void setPre_payment_fee2(String pre_payment_fee2) {
		this.pre_payment_fee2 = pre_payment_fee2;
	}

	public String getExpenses_on_arrears() {
		return expenses_on_arrears;
	}

	public void setExpenses_on_arrears(String expenses_on_arrears) {
		this.expenses_on_arrears = expenses_on_arrears;
	}

	public String getFees_on_arrears() {
		return fees_on_arrears;
	}

	public void setFees_on_arrears(String fees_on_arrears) {
		this.fees_on_arrears = fees_on_arrears;
	}

	public String getPre_payment_installment_fee() {
		return pre_payment_installment_fee;
	}

	public void setPre_payment_installment_fee(String pre_payment_installment_fee) {
		this.pre_payment_installment_fee = pre_payment_installment_fee;
	}

	public String getPre_legal_fee() {
		return pre_legal_fee;
	}

	public void setPre_legal_fee(String pre_legal_fee) {
		this.pre_legal_fee = pre_legal_fee;
	}

	public String getLegal_fee() {
		return legal_fee;
	}

	public void setLegal_fee(String legal_fee) {
		this.legal_fee = legal_fee;
	}

	public String getOther_expenses() {
		return other_expenses;
	}

	public void setOther_expenses(String other_expenses) {
		this.other_expenses = other_expenses;
	}

	public String getExpenses() {
		return expenses;
	}

	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}

	public String getUpb() {
		return upb;
	}

	public void setUpb(String upb) {
		this.upb = upb;
	}

	public String getProcess_date1() {
		return process_date1;
	}

	public void setProcess_date1(String process_date1) {
		this.process_date1 = process_date1;
	}

	public String getProcess_date2() {
		return process_date2;
	}

	public void setProcess_date2(String process_date2) {
		this.process_date2 = process_date2;
	}

	public String getTransaction_code() {
		return transaction_code;
	}

	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}

	public String getProcess_date3() {
		return process_date3;
	}

	public void setProcess_date3(String process_date3) {
		this.process_date3 = process_date3;
	}

	public String getLegal_date() {
		return legal_date;
	}

	public void setLegal_date(String legal_date) {
		this.legal_date = legal_date;
	}

	public String getCollateral_value() {
		return collateral_value;
	}

	public void setCollateral_value(String collateral_value) {
		this.collateral_value = collateral_value;
	}

	public String getLegal_date2() {
		return legal_date2;
	}

	public void setLegal_date2(String legal_date2) {
		this.legal_date2 = legal_date2;
	}

	public String getSubjective_situation_code() {
		return subjective_situation_code;
	}

	public void setSubjective_situation_code(String subjective_situation_code) {
		this.subjective_situation_code = subjective_situation_code;
	}

}
