package com.everis.demo.dto;



import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO implements Serializable {

    private String number;
    private String citycode;
    private String contrycode;

}
