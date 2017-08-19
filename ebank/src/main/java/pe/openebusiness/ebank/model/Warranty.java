package pe.openebusiness.ebank.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "WARRANTY")
public class Warranty implements Serializable {

    @Id
    @GeneratedValue(generator = "warranty_seq")
    @SequenceGenerator(name = "warranty_seq", sequenceName = "WARRANTY_SEQ", allocationSize = 1)
    @Column(name = "warranty_id")
    private Integer warranty_id;

//    @NotEmpty
//    @Column(name = "warranty_type", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warranty_type_id")
    private WarrantyType warranty_type_id;

//    @NotEmpty
//    @Column(name = "assest_type", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assest_type_id")
    private AssestType assest_type_id;

    @NotEmpty
    @Column(name = "ddescription", nullable = false)
    private String ddescription;

    @NotEmpty
    @Column(name = "aaddress", nullable = false)
    private String aaddress;

    @NotEmpty
    @Column(name = "public_record_number", nullable = false)
    private String public_record_number;

    @NotEmpty
    @Column(name = "amount_assessed", nullable = false)
    private String amount_assessed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client_id;

    //Get & Set

    public Integer getWarranty_id() {
        return warranty_id;
    }

    public void setWarranty_id(Integer warranty_id) {
        this.warranty_id = warranty_id;
    }

    public WarrantyType getWarranty_type_id() {
        return warranty_type_id;
    }

    public void setWarranty_type_id(WarrantyType warranty_type_id) {
        this.warranty_type_id = warranty_type_id;
    }

    public AssestType getAssest_type_id() {
        return assest_type_id;
    }

    public void setAssest_type_id(AssestType assest_type_id) {
        this.assest_type_id = assest_type_id;
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

    public String getPublic_record_number() {
        return public_record_number;
    }

    public void setPublic_record_number(String public_record_number) {
        this.public_record_number = public_record_number;
    }

    public String getAmount_assessed() {
        return amount_assessed;
    }

    public void setAmount_assessed(String amount_assessed) {
        this.amount_assessed = amount_assessed;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }
}
