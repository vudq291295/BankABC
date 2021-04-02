package org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.MySQL;

import javax.persistence.EntityManager;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ICustomerRespository;
import org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.BaseCRUDRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRespositoryImpl extends BaseCRUDRespositoryImpl<Customer, Long> implements ICustomerRespository {

    @Autowired
	public CustomerRespositoryImpl(Class<Customer> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
