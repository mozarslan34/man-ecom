package com.manecom.controller.registration;

import com.manecom.dto.request.RegistrationRequestDto;
import com.manecom.dto.response.BooleanResponse;
import com.manecom.service.CaptchaService;
import com.manecom.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.manecom.dto.response.BooleanResponse.success;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class CustomerRegistrationController {
    private final CustomerService customerService;
    private final CaptchaService captchaService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public BooleanResponse register(@RequestBody RegistrationRequestDto registrationRequestDto, HttpServletRequest httpServletRequest) {
        String response = httpServletRequest.getParameter("g-recaptcha-response");
        captchaService.processResponse(response, httpServletRequest.getRemoteAddr());
        customerService.register(registrationRequestDto);

        return success();
    }
}
