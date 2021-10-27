package com.everis.demo.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "isactive")
    private boolean isactive;

    @Column(name = "last_login")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;

    @Column(name = "modified")
    @Temporal(TemporalType.DATE)
    private Date modified;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "token")
    private String token;

}
