package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.HistoryPurchase;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.HistoryPurchase;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.IHistoryPurchaseReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.IHistoryPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class HistoryPurchaseReaderImpl implements IHistoryPurchaseReader{
	
	public class HistoryPurchaseSpecification implements Specification<HistoryPurchase> {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String criteria;

	    public HistoryPurchaseSpecification(String criteria) {
			super();
			this.criteria = criteria;
		}

		@Override
	    public Predicate toPredicate
	      (Root<HistoryPurchase> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	        return builder.equal(root.get("PhoneNumber"),criteria);
	    }
	}

	@Autowired
	private IHistoryPurchaseRepository _historyPurchaseRepository;

	@Override
	public List<HistoryPurchase> getHistoryByPhoneNumber(String phoneNumber) {
		var a = new HistoryPurchaseSpecification(phoneNumber);
		List<HistoryPurchase> results = _historyPurchaseRepository.findAll(Specification.where(a));
		return results;
	}


	
}
