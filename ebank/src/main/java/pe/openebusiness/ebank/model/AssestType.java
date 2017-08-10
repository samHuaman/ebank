package pe.openebusiness.ebank.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "ASSEST_TYPE")
public class AssestType  implements Serializable{

    @Id
    @GeneratedValue(generator = "assest_seq")
    @SequenceGenerator(name = "assest_seq", sequenceName = "ASSEST_SEQ", allocationSize = 1)
    @Column(name = "assest_type_id")
    private Integer assest_type_id;

    @NotEmpty
    @Column(name = "ddescription")
    private String ddescription;

    public Integer getAssest_type_id() {
        return assest_type_id;
    }

    public void setAssest_type_id(Integer assest_type_id) {
        this.assest_type_id = assest_type_id;
    }

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }
}
