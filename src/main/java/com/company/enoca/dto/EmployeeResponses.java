package com.company.enoca.dto;

import java.util.List;

public class EmployeeResponses {
    private int statusCode;
    private String status;
    private List<EmployeeDto> list;

    private EmployeeDto employee;

    public EmployeeResponses() {
    }
    public EmployeeResponses(int statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public EmployeeResponses(int statusCode, String status, List<EmployeeDto> list) {
        this.statusCode = statusCode;
        this.status = status;
        this.list = list;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeDto> getList() {
        return list;
    }

    public void setList(List<EmployeeDto> list) {
        this.list = list;
    }
}
