package com.manecom.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReCaptchaInvalidException extends RuntimeException {
    String message;
}
