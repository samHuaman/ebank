package pe.openebusiness.ebank.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name= "WARRANTY")
public class Warranty implements Serializable {

    @Id
    @GeneratedValue(generator = "warranty_seq")
    @SequenceGenerator(name = "warranty_seq", sequenceName = "WARRANTY_SEQ",
    allocationSize = 1)
    @Column(name = "warranty_id")
    private Integer warranty_id;

    @NotEmpty
    @Column(name = "customer_type")
    private String customer_type;

    @NotEmpty
    @Column(name = "customer", nullable = false)
    private String customer;

    @NotEmpty
    @Column(name = "total_assessed", nullable = false)
    private String total_assessed;

//    @NotEmpty
//    @Column(name = "warranty_type", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warranty_type_id")
    private WarrantyType warranty_type;

//    @NotEmpty
//    @Column(name = "assest_type", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assest_type_id")
    private AssestType assest_type;

    @NotEmpty
    @Column(name = "ddescription", nullable = false)
    private String ddescription;

    @NotEmpty
    @Column(name = "aaddress", nullable = false)
    private String aaddress;

    @NotEmpty
    @Column(name = "public_record_number", nullable = false)
    private Integer public_record_number;

    @NotEmpty
    @Column(name = "amount_assessed", nullable = false)
    private String amount_assessed;

    @NotEmpty
    @Column(name = "policy", nullable = false)
    private String policy;


    @Column(name = "customer_id", nullable = false)
    private Integer customer_id;

    //Get & Set

    public Integer getWarranty_id() {
        return warranty_id;
    }

    public void setWarranty_id(Integer warranty_id) {
        this.warranty_id = warranty_id;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTotal_assessed() {
        return total_assessed;
    }

    public void setTotal_assessed(String total_assessed) {
        this.total_assessed = total_assessed;
    }

    public WarrantyType getWarranty_type() {
        return warranty_type;
    }

    public void setWarranty_type(WarrantyType warranty_type) {
        this.warranty_type = warranty_type;
    }

    public AssestType getAssest_type() {
        return assest_type;
    }

    public void setAssest_type(AssestType assest_type) {
        this.assest_type = assest_type;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public Integer getPublic_record_number() {
        return public_record_number;
    }

    public void setPublic_record_number(Integer public_record_number) {
        this.public_record_number = public_record_number;
    }

    public String getAmount_assessed() {
        return amount_assessed;
    }

    public void setAmount_assessed(String amount_assessed) {
        this.amount_assessed = amount_assessed;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
}
