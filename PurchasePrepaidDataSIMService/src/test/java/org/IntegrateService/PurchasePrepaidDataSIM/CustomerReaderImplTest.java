package org.IntegrateService.PurchasePrepaidDataSIM;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.Customer.CustomerReaderImpl;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer.ICustomerReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ICustomerRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CustomerReaderImplTest {
	
    @TestConfiguration
    static class EmployeeServiceImplCustomerReaderImplTestContextConfiguration {
 
        @Bean
        public ICustomerReader customerReader() {
            return new CustomerReaderImpl();
        }
    }
//    
    @Autowired
    public ICustomerReader customerReader;
//    @InjectMocks
//    ICustomerReader customerReader;

    @MockBean 
    ICustomerRespository iCustomerRespository;

    @Test
    public void findOneShouldSuccesfull() {
    	Customer customer = new Customer();
    	customer.setId(1L);
    	customer.setPhoneNumber("0398745623");
        Optional<Customer> optionalEntityType = Optional.of(customer);

        Mockito.lenient().when(iCustomerRespository.findById(customer.getId()))
        .thenReturn(optionalEntityType);
        var result = customerReader.findOne(customer.getId());

        assertThat(result.getPhoneNumber()).isEqualTo(customer.getPhoneNumber());

    }
}
