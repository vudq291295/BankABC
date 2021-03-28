package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.Customer;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer.ICustomerReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerReaderImpl implements ICustomerReader{
	
	@Autowired
	private ICustomerRespository _iCustomerRespository;

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return _iCustomerRespository.findById(id).get();
	}

}
