package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import javax.validation.Valid;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.IPurchaseVoucheReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.PurchaseVoucheRequest;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.VoucherResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase_vouche")
public class PurchaseVoucheController {

	//TODO: Add Handle Exception
	//TODO: Add Validation
	@Autowired
	IPurchaseVoucheReader purchaseVoucheReader;
	  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	@ResponseBody
	public ResponseEntity PurchaseVouche(@Valid @RequestBody PurchaseVoucheRequest purchaseVoucheRequest ) {
		var result =  purchaseVoucheReader.PurchaseVouche(purchaseVoucheRequest);
		if(!result.isIsSuccess())
		{
			  return new ResponseEntity(result,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<VoucherResponseMessage>(result,HttpStatus.OK);
	}
}
