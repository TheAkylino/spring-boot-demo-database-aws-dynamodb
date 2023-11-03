package com.akylino.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String id;
    private String customerFullName;
    private Integer age;
    private String birthName;
    private String telephoneContact;
    private String addressPrincipal;
    private String addressSecond;
    private Boolean activeFlag;
}
