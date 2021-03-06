package org.IntegrateService.PurchasePrepaidDataSIM.Model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class PurchaseVoucheRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotBlank(message = "must be supplied PhoneNumber")
	private String PhoneNumber;
	
	private Long TypeVoucherId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public Long getTypeVoucherId() {
		return TypeVoucherId;
	}

	public void setTypeVoucherId(Long typeVoucherId) {
		TypeVoucherId = typeVoucherId;
	}
	
}
