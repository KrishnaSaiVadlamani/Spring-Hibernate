package com.jackson.json.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

}
