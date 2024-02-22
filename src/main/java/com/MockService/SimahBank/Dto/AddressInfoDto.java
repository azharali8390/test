package com.MockService.SimahBank.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AddressInfoDto {

    private int addressType;
    private String street;
    private int buildingNumber;
    private int zipCode;
    private int additionalNumber;
    private int city;
    private String district;
}
