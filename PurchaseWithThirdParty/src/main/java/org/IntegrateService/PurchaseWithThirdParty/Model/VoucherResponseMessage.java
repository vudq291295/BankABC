package org.IntegrateService.PurchaseWithThirdParty.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherResponseMessage {
	private String VoucherCode;
	private boolean IsSuccess;
	private String Message;
	
	public String getVoucherCode() {
		return VoucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		VoucherCode = voucherCode;
	}

	public boolean isIsSuccess() {
		return IsSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		IsSuccess = isSuccess;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	}
