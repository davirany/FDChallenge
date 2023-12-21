package com.example.fdchallenge.service;

import com.example.fdchallenge.DTO.CustomerDTO;
import com.example.fdchallenge.exception.LongCustomerNameException;
import com.example.fdchallenge.exception.LongCustomerPasswordException;
import com.example.fdchallenge.exception.ShortCustomerNameException;
import com.example.fdchallenge.exception.ShortCustomerPasswordException;
import com.example.fdchallenge.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void testPostCustomerWithShortCustomerName() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Ab");
        customerDTO.setEmail("test@example.com");
        customerDTO.setPassword("password123");

        assertThrows(ShortCustomerNameException.class, () -> customerService.createCustomer(customerDTO));
    }

    @Test
    void testPostCustomerWithLongCustomerName() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("VeryLongCustomerNameThatExceedsTheMaximumCharacterLimitOfFifty");
        customerDTO.setEmail("test@example.com");
        customerDTO.setPassword("password123");

        assertThrows(LongCustomerNameException.class, () -> customerService.createCustomer(customerDTO));
    }

    @Test
    void testPostCustomerWithShortCustomerPassword() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("John Doe");
        customerDTO.setEmail("test@example.com");
        customerDTO.setPassword("pwd");

        assertThrows(ShortCustomerPasswordException.class, () -> customerService.createCustomer(customerDTO));
    }

    @Test
    void testPostCustomerWithLongCustomerPassword() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("John Doe");
        customerDTO.setEmail("test@example.com");
        customerDTO.setPassword("VeryLongPasswordThatExceedsTheMaximumCharacterLimitOfTwenty");

        assertThrows(LongCustomerPasswordException.class, () -> customerService.createCustomer(customerDTO));
    }

    // Add more tests for other validation scenarios and normal cases
}
