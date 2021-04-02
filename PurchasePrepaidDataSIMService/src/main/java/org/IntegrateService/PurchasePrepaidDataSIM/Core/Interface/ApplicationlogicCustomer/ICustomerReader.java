package org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.springframework.security.core.userdetails.UserDetails;

public interface ICustomerReader {
	Customer findOne(Long id);
	UserDetails findByPhoneNumber(String id);
}
