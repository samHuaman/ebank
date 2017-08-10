package pe.openebusiness.ebank.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WARRANTY_TYPE")
public class WarrantyType implements Serializable {

    @Id
    @GeneratedValue(generator = "warranty_type_id")
    @SequenceGenerator(name = "warranty_type_id", sequenceName = "WARRANTY_TYPE_SEQ", allocationSize = 1)
    @Column(name = "warranty_type_id")
    private Integer warranty_type_id;

    @NotEmpty
    @Column(name = "ddescription")
    private String ddescription;

    public Integer getWarranty_type_id() {
        return warranty_type_id;
    }

    public void setWarranty_type_id(Integer warranty_type_id) {
        this.warranty_type_id = warranty_type_id;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }
}
