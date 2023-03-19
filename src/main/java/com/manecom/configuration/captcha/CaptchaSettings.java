package com.manecom.configuration.captcha;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
@Data
public class CaptchaSettings {

    private String site;
    private String secret;

}
