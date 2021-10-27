package com.everis.demo.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "citycode")
    private String citycode;

    @Column(name = "contrycode")
    private String contrycode;

    @Column(name = "userUuid")
    private String userUuid;

    public Phone() {
    }

}
