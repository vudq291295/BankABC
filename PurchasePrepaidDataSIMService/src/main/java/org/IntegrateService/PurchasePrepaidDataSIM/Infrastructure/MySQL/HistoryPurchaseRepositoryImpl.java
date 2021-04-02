package org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.MySQL;

import javax.persistence.EntityManager;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.HistoryPurchase;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.IHistoryPurchaseRepository;
import org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.BaseCRUDRespositoryImpl;

public class HistoryPurchaseRepositoryImpl extends BaseCRUDRespositoryImpl<HistoryPurchase, Long> implements IHistoryPurchaseRepository{

	public HistoryPurchaseRepositoryImpl(Class<HistoryPurchase> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}

}
