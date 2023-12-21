package com.example.fdchallenge.service;

import com.example.fdchallenge.DTO.CustomerDTO;
import com.example.fdchallenge.ErrorMessage;
import com.example.fdchallenge.converter.CustomerConverter;
import com.example.fdchallenge.exception.ShortCustomerNameException;
import com.example.fdchallenge.exception.ShortCustomerPasswordException;
import com.example.fdchallenge.model.Customer;
import com.example.fdchallenge.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        validateCustomerDTO(customerDTO);

        Customer customer = customerConverter.convertToEntity(customerDTO);
        customer = Optional.ofNullable(customerRepository.save(customer))
                .orElseThrow(() -> new RuntimeException("Failed to save customer"));

        return customerConverter.convertToDTO(customer);
    }

    private void validateCustomerDTO(CustomerDTO customerDTO) {
        Optional.ofNullable(customerDTO.getName())
                .filter(name -> name.length() >= 3 && name.length() <= 50)
                .orElseThrow(() -> new ShortCustomerNameException(ErrorMessage.SHORT_CUSTOMER_NAME.getMessage()));

        Optional.ofNullable(customerDTO.getPassword())
                .filter(password -> password.length() >= 6 && password.length() <= 20)
                .orElseThrow(() -> new ShortCustomerPasswordException(ErrorMessage.SHORT_CUSTOMER_PASSWORD.getMessage()));
    }
}
