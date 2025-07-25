package com.ecommerce.sb_ecom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be atleast 5 character")
    private String streetName;

    @NotBlank
    @Size(min = 5, message = "Building name must be atleast 5 character")
    private String streetNumber;

    @NotBlank
    @Size(min = 4, message = "city name must be atleast 4 character")
    private String city;

    @NotBlank
    @Size(min = 2, message = "state name must be atleast 2 character")
    private String state;

    @NotBlank
    @Size(min = 2, message = "state name must be atleast 2 character")
    private String country;

    @NotBlank
    @Size(min = 6, message = "pincode name must be atleast 6 character")
    private String pincode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String streetName, String streetNumber, String city, String state, String country, String pincode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
