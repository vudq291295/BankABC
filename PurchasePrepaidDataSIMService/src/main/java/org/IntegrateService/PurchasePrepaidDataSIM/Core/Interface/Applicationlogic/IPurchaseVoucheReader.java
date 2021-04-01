package org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.Applicationlogic;

import org.IntegrateService.PurchasePrepaidDataSIM.Model.PurchaseVoucheRequest;
import org.IntegrateService.PurchasePrepaidDataSIM.Model.VoucherResponseMessage;

public interface IPurchaseVoucheReader {
	VoucherResponseMessage PurchaseVouche(PurchaseVoucheRequest purchaseVoucheRequest);
}
