package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.TypeVoucher;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.TypeVoucher;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.ITypeVoucherWriter;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ITypeVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeVoucherWriterImpl implements ITypeVoucherWriter{
	
	@Autowired
	private ITypeVoucherRepository _typeVoucherRepository;

	public TypeVoucher Insert(TypeVoucher typeVoucher) {
		var result = _typeVoucherRepository.save(typeVoucher);
		return result;
	}
}
