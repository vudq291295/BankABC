package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.Customer;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.ApplicationlogicCustomer.ICustomerReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Test")
public class TestController {
	
	  @Autowired 
	  ICustomerReader customerReader;

	  
	  @GetMapping("/users")
	  @Secured( value={"ROLE_ANONYMOUS"})
	  public Customer getAllUsers(@RequestHeader("id") Long id) {
		var result =  customerReader.findOne(id);
	    return result;
	  }

}
