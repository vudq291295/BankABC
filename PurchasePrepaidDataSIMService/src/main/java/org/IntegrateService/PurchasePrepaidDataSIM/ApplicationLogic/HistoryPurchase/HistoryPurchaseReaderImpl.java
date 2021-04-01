package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.HistoryPurchase;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.IHistoryPurchaseReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryPurchaseReaderImpl implements IHistoryPurchaseReader{
	
	private ICustomerRespository _iCustomerRespository;

	public HistoryPurchaseReaderImpl(ICustomerRespository iCustomerRespository) {
		_iCustomerRespository = iCustomerRespository;
	}
}
