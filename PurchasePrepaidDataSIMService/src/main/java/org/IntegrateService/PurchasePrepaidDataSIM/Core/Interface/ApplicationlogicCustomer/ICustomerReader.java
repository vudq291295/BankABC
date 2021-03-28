package org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;

public interface ICustomerReader {
	Customer findOne(Long id);
}
