package com.company.enoca.dto;

import com.company.enoca.entities.CompanyStatus;
import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private CompanyStatus status;
    private String phoneNumber;

}
