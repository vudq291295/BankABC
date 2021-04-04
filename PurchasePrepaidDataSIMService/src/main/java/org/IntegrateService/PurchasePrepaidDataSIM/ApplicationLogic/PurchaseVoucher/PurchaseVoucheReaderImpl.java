package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.PurchaseVoucher;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.HistoryPurchase;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Enums.HistoryVoucherStatus;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic.IPurchaseVoucheReader;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.IHistoryPurchaseRepository;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.PurchaseVoucheRequest;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.VoucherResponseMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class PurchaseVoucheReaderImpl implements IPurchaseVoucheReader{
    public static final String ROUTING_KEY = "old.car";

	  @Autowired
	  RabbitTemplate asyncRabbitTemplate;
	
	  @Autowired
	  private IHistoryPurchaseRepository _historyPurchaseRepository;


	@Override
	public VoucherResponseMessage PurchaseVouche(PurchaseVoucheRequest purchaseVoucheRequest) {
		//TODO:  Assume Payment is success
		VoucherResponseMessage rabbitConverter = new VoucherResponseMessage();
		try {
			//  Add request purchase to historyPurchase
			var historyPurchase = new HistoryPurchase();
			historyPurchase.setPhoneNumber(purchaseVoucheRequest.getPhoneNumber());
			historyPurchase.setTypeVoucherID(purchaseVoucheRequest.getTypeVoucherId());
			historyPurchase.setStatus(HistoryVoucherStatus.PENDING);
			var historyPurchaseEntity = _historyPurchaseRepository.save(historyPurchase);
			purchaseVoucheRequest.setId(historyPurchaseEntity.getId());
			System.out.println("historyPurchaseEntity getId: "+historyPurchaseEntity.getId());
			System.out.println("historyPurchaseEntity getTypeVoucherID: "+historyPurchaseEntity.getTypeVoucherID());

			asyncRabbitTemplate.setReceiveTimeout(3000);
			rabbitConverter = asyncRabbitTemplate.convertSendAndReceiveAsType(
					  "reflectoring.cars",
					  ROUTING_KEY,
					  purchaseVoucheRequest,
	                new ParameterizedTypeReference<>() {});
			System.out.println("rabbitConverterFuture: "+rabbitConverter);

			if(rabbitConverter!=null && rabbitConverter.isIsSuccess()) {
				historyPurchaseEntity.setVoucherCode(rabbitConverter.getVoucherCode());
				historyPurchaseEntity.setStatus(HistoryVoucherStatus.DONE);
				_historyPurchaseRepository.save(historyPurchaseEntity);
			}
		}
		catch(Exception ex) {
			
		}

	    return rabbitConverter;
	}

}
