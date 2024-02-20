package com.nabilaitnacer.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestRegisterDto implements Serializable {
    String name;
    String email;
    String lastname;
}