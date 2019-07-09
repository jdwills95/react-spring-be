package com.emp.resp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

//

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "employee_group")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String fName;
    private String lName;
    private String address;
    private String city;
    private String stateOrProvince;
    private String postalCode;
    private String homePhone;
    private String cellPhone;
    private String email;

}
