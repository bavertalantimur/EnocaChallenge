package com.company.enoca.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@RequiredArgsConstructor
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "mail_address")
    private String mailAddress;
    @Column(name = "hire_date")
    private Date hireDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    Employee(Long id,String firstName,String lastName,String phoneNumber,String mailAddress,Date hireDate,Company company){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.mailAddress=mailAddress;
        this.hireDate=hireDate;
        this.company=company;
    }


}
