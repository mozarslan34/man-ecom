package com.manecom.mapper;


import com.manecom.dto.request.RegistrationRequestDto;
import com.manecom.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(RegistrationRequestDto registrationRequestDto) {
        Customer customer = new Customer();
        customer.setPassword(registrationRequestDto.getPassword());
        customer.setCustomerSurname(registrationRequestDto.getCustomerSurname());
        customer.setCustomerName(registrationRequestDto.getCustomerName());
        customer.setPhoneNumber(registrationRequestDto.getPhoneNumber());
        customer.setEmail(registrationRequestDto.getEmail());

        return customer;
    }

}
