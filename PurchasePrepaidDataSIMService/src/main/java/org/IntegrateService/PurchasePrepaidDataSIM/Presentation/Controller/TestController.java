package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Test")
public class TestController {
	
	  @GetMapping("/users")
	  @Secured( value={"ROLE_ANONYMOUS"})
	  public String getAllUsers() {
	    return "abc";
	  }

}
