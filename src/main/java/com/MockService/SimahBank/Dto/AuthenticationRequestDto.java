package com.MockService.SimahBank.Dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AuthenticationRequestDto {
    String username;
    String Password;
}
