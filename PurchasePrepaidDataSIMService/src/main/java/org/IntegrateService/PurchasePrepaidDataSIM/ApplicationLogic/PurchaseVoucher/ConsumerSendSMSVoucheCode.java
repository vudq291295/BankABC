package org.IntegrateService.PurchasePrepaidDataSIM.ApplicationLogic.PurchaseVoucher;

import java.io.IOException;
import java.net.URISyntaxException;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Enums.HistoryVoucherStatus;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.IHistoryPurchaseRepository;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.PurchaseVoucheRequest;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.SendSMSVoucherRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerSendSMSVoucheCode {
	@Autowired
	 private IHistoryPurchaseRepository _historyPurchaseRepository;
	
    @RabbitListener(queues = "response.phone")
    public void receive(SendSMSVoucherRequest sendSMSVoucherRequest){
    	var entity = _historyPurchaseRepository.findById(sendSMSVoucherRequest.getId());
    	if(entity!=null) {
    		var historyPurchase = entity.get();
    		historyPurchase.setVoucherCode(sendSMSVoucherRequest.getVoucherCode());
    		historyPurchase.setStatus(HistoryVoucherStatus.DONE_PHONE);
    		_historyPurchaseRepository.save(historyPurchase);
    	}
    	
		System.out.println("purchaseVoucheRequest: " + sendSMSVoucherRequest.getId());
    }
}
