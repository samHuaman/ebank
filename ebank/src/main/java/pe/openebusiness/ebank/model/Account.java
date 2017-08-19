package pe.openebusiness.ebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AACCOUNT")
public class Account  implements Serializable {

    @Id
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "aaccount")
    private String aaccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
//    @Column(name = "product_id")
    private Product product_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_product_id")
//    @Column(name = "sub_product_id")
    private SubProduct sub_product_id;

    @Column(name = "disbur_date")
    private Date disbur_date;


    @Column(name = "amount_requested")
    private Double amount_requested;

    @Column(name = "payment_priority")
    private String payment_priority;

    @Column(name = "number_quotas")
    private Integer number_quotas;

    @Column(name = "payday")
    private Integer payday;

    @Column(name = "total_length")
    private String total_length;

    @Column(name = "interest_rate_mora")
    private Integer interest_rate_mora;

    @Column(name = "an_effe_compe_inte_rate")
    private Integer an_effe_compe_inte_rate;

    @Column(name = "comm_for_oper_expen")
    private Integer comm_for_oper_expen;

    @Column(name = "insurance")
    private String insurance;

    @Column(name = "total_debt")
    private Double total_debt;

    @Column(name = "outstanding_fees")
    private Integer outstanding_fees;

    @Column(name = "tota_inte_mora")
    private Integer tota_inte_mora;

    @Column(name = "tota_compe_inte")
    private Integer tota_compe_inte;

    @Column(name = "tota_insu")
    private Integer tota_insu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_type_id")
    private PersonType person_type_id;

    @Column(name = "AMOUNT_DISBURSED")
    private Double AMOUNT_DISBURSED;

    @Column(name = "AMOUNT")
    private Double AMOUNT;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY_TYPE_ID")
//    @Column(name = "CURRENCY_TYPE_ID")
    private Currency CURRENCY_TYPE_ID;


    //Get && Set

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAaccount() {
        return aaccount;
    }

    public void setAaccount(String aaccount) {
        this.aaccount = aaccount;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public SubProduct getSub_product_id() {
        return sub_product_id;
    }

    public void setSub_product_id(SubProduct sub_product_id) {
        this.sub_product_id = sub_product_id;
    }

    public Date getDisbur_date() {
        return disbur_date;
    }

    public void setDisbur_date(Date disbur_date) {
        this.disbur_date = disbur_date;
    }

    public Double getAmount_requested() {
        return amount_requested;
    }

    public void setAmount_requested(Double amount_requested) {
        this.amount_requested = amount_requested;
    }

    public String getPayment_priority() {
        return payment_priority;
    }

    public void setPayment_priority(String payment_priority) {
        this.payment_priority = payment_priority;
    }

    public Integer getNumber_quotas() {
        return number_quotas;
    }

    public void setNumber_quotas(Integer number_quotas) {
        this.number_quotas = number_quotas;
    }

    public Integer getPayday() {
        return payday;
    }

    public void setPayday(Integer payday) {
        this.payday = payday;
    }

    public String getTotal_length() {
        return total_length;
    }

    public void setTotal_length(String total_length) {
        this.total_length = total_length;
    }

    public Integer getInterest_rate_mora() {
        return interest_rate_mora;
    }

    public void setInterest_rate_mora(Integer interest_rate_mora) {
        this.interest_rate_mora = interest_rate_mora;
    }

    public Integer getAn_effe_compe_inte_rate() {
        return an_effe_compe_inte_rate;
    }

    public void setAn_effe_compe_inte_rate(Integer an_effe_compe_inte_rate) {
        this.an_effe_compe_inte_rate = an_effe_compe_inte_rate;
    }

    public Integer getComm_for_oper_expen() {
        return comm_for_oper_expen;
    }

    public void setComm_for_oper_expen(Integer comm_for_oper_expen) {
        this.comm_for_oper_expen = comm_for_oper_expen;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Double getTotal_debt() {
        return total_debt;
    }

    public void setTotal_debt(Double total_debt) {
        this.total_debt = total_debt;
    }

    public Integer getOutstanding_fees() {
        return outstanding_fees;
    }

    public void setOutstanding_fees(Integer outstanding_fees) {
        this.outstanding_fees = outstanding_fees;
    }

    public Integer getTota_inte_mora() {
        return tota_inte_mora;
    }

    public void setTota_inte_mora(Integer tota_inte_mora) {
        this.tota_inte_mora = tota_inte_mora;
    }

    public Integer getTota_compe_inte() {
        return tota_compe_inte;
    }

    public void setTota_compe_inte(Integer tota_compe_inte) {
        this.tota_compe_inte = tota_compe_inte;
    }

    public Integer getTota_insu() {
        return tota_insu;
    }

    public void setTota_insu(Integer tota_insu) {
        this.tota_insu = tota_insu;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public PersonType getPerson_type_id() {
        return person_type_id;
    }

    public void setPerson_type_id(PersonType person_type_id) {
        this.person_type_id = person_type_id;
    }

    public Double getAMOUNT_DISBURSED() {
        return AMOUNT_DISBURSED;
    }

    public void setAMOUNT_DISBURSED(Double AMOUNT_DISBURSED) {
        this.AMOUNT_DISBURSED = AMOUNT_DISBURSED;
    }

    public Double getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(Double AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public Currency getCURRENCY_TYPE_ID() {
        return CURRENCY_TYPE_ID;
    }

    public void setCURRENCY_TYPE_ID(Currency CURRENCY_TYPE_ID) {
        this.CURRENCY_TYPE_ID = CURRENCY_TYPE_ID;
    }
}
