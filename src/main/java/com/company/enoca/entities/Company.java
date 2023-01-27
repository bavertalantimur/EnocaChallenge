package com.company.enoca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "mail_address")
    private String mailAddress;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Employee> employees;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Company(Long id, String name, CompanyStatus status, String phoneNumber, String address, String mailAddress,List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.mailAddress = mailAddress;
        this.employees=employees;
    }

    public Company() {

    }
}
