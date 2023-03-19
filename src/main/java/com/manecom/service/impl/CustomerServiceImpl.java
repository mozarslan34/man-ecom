package com.manecom.service.impl;

import com.manecom.mapper.CustomerMapper;
import com.manecom.dto.request.RegistrationRequestDto;
import com.manecom.model.entity.customer.Customer;
import com.manecom.repository.CustomerRepository;
import com.manecom.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void register(RegistrationRequestDto reqistrationRequest) {
        Customer customer = customerMapper.toCustomer(reqistrationRequest);
        customerRepository.save(customer);
    }
}
