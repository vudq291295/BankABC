package org.IntegrateService.PurchasePrepaidDataSIM.Presentation.Controller;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.TypeVoucher;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.ITypeVoucherWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type_voucher")
public class TypeVoucherController {
	
	@Autowired
	ITypeVoucherWriter _typeVoucherWriter;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<TypeVoucher> Post(@RequestBody TypeVoucher typeVoucher) {
		System.out.println("asdsad");
		var result =  _typeVoucherWriter.Insert(typeVoucher);
	  return new ResponseEntity<TypeVoucher>(result,HttpStatus.OK);
	}

}
