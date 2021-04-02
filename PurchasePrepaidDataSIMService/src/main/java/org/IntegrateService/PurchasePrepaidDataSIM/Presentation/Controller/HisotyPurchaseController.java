package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.IHistoryPurchaseReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hisoty_purchase")
public class HisotyPurchaseController {
	@Autowired
	private IHistoryPurchaseReader _historyPurchaseReader;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity Get(@RequestParam String phoneNumber) {
		System.out.println("asdsad");
		var result =  _historyPurchaseReader.getHistoryByPhoneNumber(phoneNumber);
	  return new ResponseEntity(result,HttpStatus.OK);
	}
}
