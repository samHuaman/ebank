package pe.openebusiness.ebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_STATUS")
public class AccountStatus implements Serializable {

    @Id
    @Column(name = "account_status_id")
    private Integer account_status_id;

    @Column(name = "operation_date")
    private Date operation_date;

    @Column(name = "description")
    private String description;

    @Column(name = "office")
    private String office;

    @Column(name = "canal")
    private String canal;

    @Column(name = "operation")
    private String operation;

    @Column(name = "pay")
    private Double pay;

    @Column(name = "itf")
    private Double itf;

    @Column(name = "accountant")
    private Double accountant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account_id;

    //GET & SET
    public Integer getAccount_status_id() {
        return account_status_id;
    }

    public void setAccount_status_id(Integer account_status_id) {
        this.account_status_id = account_status_id;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Double getItf() {
        return itf;
    }

    public void setItf(Double itf) {
        this.itf = itf;
    }

    public Double getAccountant() {
        return accountant;
    }

    public void setAccountant(Double accountant) {
        this.accountant = accountant;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }
}
