package com.MockService.SimahBank.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class GeneralInfoDTO {
    private String expiryDate;
    private boolean isHijriDate;
    private int nationality;
    private String familyName;
    private String firstName;
    private String secondName;
    private String thirdName;
    private int gender;
    private String dateOfBirth;
    private boolean isHijriDateOfBirth;
    private String name;
    private int legalId;
    private int activityId;
    private int noOfEmployeesId;
}
