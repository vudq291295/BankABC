package org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic;

import java.util.List;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.HistoryPurchase;
import org.springframework.data.jpa.repository.Query;

public interface IHistoryPurchaseReader {
	
	//TODO: Is Simple get by phoneNumber, need update filter and paging
	@Query("")
	List<HistoryPurchase> getHistoryByPhoneNumber(String phoneNumber);
}
