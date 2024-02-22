package com.MockService.SimahBank.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class BasicInfoDTO {
    private int enquiryTypeId;
    private String idIssuerID;
    private int amount;
    private int cityId;
    private int productId;
    private int creditInstrumentId;
    private String idNumber;
    private String memberRefNo;
}
