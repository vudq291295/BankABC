package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.Customer;

import java.util.ArrayList;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer.ICustomerReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerReaderImpl implements ICustomerReader{
	
	@Autowired
	private ICustomerRespository _iCustomerRespository;

	@Override
	public Customer findOne(Long id) {
		return _iCustomerRespository.findById(id).get();
	}
	
	@Override
	public UserDetails findByPhoneNumber(String phoneNumber) {
		// TODO get user in Database
		return new User(phoneNumber, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
				new ArrayList<>());
	}

}
