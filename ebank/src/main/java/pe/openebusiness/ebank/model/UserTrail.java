package pe.openebusiness.ebank.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Paco on 17/07/2017.
 */
@Entity
@Table(name = "USER_TRAIL")
public class UserTrail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_trail_id")
    private Integer user_trail_id;

    @NotEmpty
    @Column(name = "user_id", nullable = false)
    private String user_id;

    @NotEmpty
    @Column(name = "ddate", nullable = false)
    private Date ddate;

    @NotEmpty
    @Column(name = "changes", nullable = false)
    private String changes;

    @NotEmpty
    @Column(name = "trigger_username", nullable = false)
    private String trigger_username;


}
