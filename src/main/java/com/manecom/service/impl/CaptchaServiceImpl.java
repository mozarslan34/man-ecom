package com.manecom.service.impl;

import com.manecom.configuration.captcha.CaptchaSettings;
import com.manecom.dto.response.GoogleResponse;
import com.manecom.exception.InvalidReCaptchaException;
import com.manecom.exception.ReCaptchaInvalidException;
import com.manecom.service.CaptchaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private CaptchaSettings captchaSettings;


    private RestOperations restTemplate;

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    @Override
    public void processResponse(String response,String Ip) {
        if(!responseSanityCheck(response)) {
            throw new InvalidReCaptchaException("Response contains invalid characters");
        }

        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
                captchaSettings.getSecret(), response, Ip));

        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);

        if(!googleResponse.isSuccess()) {
            throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
        }
    }

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }
}
