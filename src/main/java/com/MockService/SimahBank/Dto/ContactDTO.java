package com.MockService.SimahBank.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class ContactDTO {

    private int contactType;
    private String areaCode;
    private String phoneNumber;
    private String extension;
    private String countryCode;
}
