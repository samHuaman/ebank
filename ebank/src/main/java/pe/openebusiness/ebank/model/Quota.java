package pe.openebusiness.ebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "QUOTA")
public class Quota implements Serializable {

    @Id
    @Column(name = "quota_id")
    private Integer quota_id;

    @Column(name = "due_date")
    private Date due_date;

    @Column(name = "capital")
    private Double capital;

    @Column(name = "compensatory")
    private Double compensatory;

    @Column(name = "arrears")
    private Double arrears;

    @Column(name = "postages")
    private Double postages;

    @Column(name = "total_fee")
    private Double total_fee;

    @Column(name = "insurance")
    private Double insurance;

    @Column(name = "o_insurances")
    private Double o_insurances;

    @Column(name = "total_pay")
    private Double total_pay;

    @Column(name = "schedule_id")
    private Integer schedule_id;
}










