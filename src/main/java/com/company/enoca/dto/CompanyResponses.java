package com.company.enoca.dto;

import com.company.enoca.entities.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponses extends Responses {
    List<CompanyDto> list;

    public CompanyResponses(int statusCode, String status, String message,List<CompanyDto> list){
        super(statusCode,status,message);
        this.list=list;
    }
    public CompanyResponses(int statusCode, String status, String message){
        super(statusCode,status,message);
    }


}
