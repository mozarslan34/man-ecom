package com.manecom.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InvalidReCaptchaException extends RuntimeException {
    String message;
}
