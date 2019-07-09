package com.emp.resp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

//

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NonNull
    @Column(name = "FIRST_NAME")
    private String fName;
    @Column(name = "LAST_NAME")
    private String lName;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String stateOrProvince;
    @Column(name = "ZIP")
    private String postalCode;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "CELL_PHONE")
    private String cellPhone;
    @Column(name = "EMAIL")
    private String email;

}
