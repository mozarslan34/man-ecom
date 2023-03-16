package com.manecom.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestDto {
    private String customerName;
    private String customerSurname;
    private String email;
    private String phoneNumber;
    private String password;
}
