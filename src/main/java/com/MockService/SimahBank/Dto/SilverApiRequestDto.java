package com.MockService.SimahBank.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class SilverApiRequestDto {
    private BasicInfoDTO basicInfo;
    private GeneralInfoDTO generalInfo;
    private List<ContactDTO> contacts;
    private AddressInfoDto addressInfo;
    private boolean isNationalId;
}
