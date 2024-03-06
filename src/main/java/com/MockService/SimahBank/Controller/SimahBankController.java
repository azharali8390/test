package com.MockService.SimahBank.Controller;

import com.MockService.SimahBank.Dto.AuthenticationRequestDto;
import com.MockService.SimahBank.Dto.BronzeApiRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SimahBankController {



    @GetMapping("/hello")
    public String hello() throws IOException, JSONException {

      return "hello world";
    }

    @PostMapping("/Identity/login")
    public String authenticate(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        if(StringUtils.isNotBlank(authenticationRequestDto.getUsername()) &&
                StringUtils.isNotBlank(authenticationRequestDto.getPassword()) )
        {
            return "Logged In";
        }
        else {
            return " Please provide all the required fields";
        }

    }

    @GetMapping("/enquiry/commercial/bronze")
    public String BronzeApi(@RequestBody BronzeApiRequestDto bronzeApiRequestDto) throws IOException, JSONException {

        return "Bronze Api";
    }

    @GetMapping("/enquiry/commercial/silver/report")
    public String SilverApi(@RequestBody BronzeApiRequestDto bronzeApiRequestDto) throws IOException {

        return "Silver Api";
    }

}
