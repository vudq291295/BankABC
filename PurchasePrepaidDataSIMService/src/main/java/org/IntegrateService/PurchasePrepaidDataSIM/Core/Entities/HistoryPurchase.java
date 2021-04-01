package org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Enums.HistoryVoucherStatus;

@Entity
@Table(name = "history_purchase")
public class HistoryPurchase extends BaseEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="phone_number")
    @Size(min = 1, max = 13)
    private String PhoneNumber;
    
    @Column(name="voucher_code")
    private String VoucherCode;

    @Column(name="type_voucher_id")
    private Long TypeVoucherID;
    
    @ManyToOne
    @JoinColumn(name="type_voucher_id",insertable = false, updatable = false)
    private TypeVoucher TypeVoucher;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private HistoryVoucherStatus Status;

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

	public TypeVoucher getTypeVoucher() {
		return TypeVoucher;
	}

	public void setTypeVoucher(TypeVoucher typeVoucher) {
		TypeVoucher = typeVoucher;
	}

	public Long getTypeVoucherID() {
		return TypeVoucherID;
	}

	public void setTypeVoucherID(Long typeVoucherID) {
		TypeVoucherID = typeVoucherID;
	}

	public HistoryVoucherStatus getStatus() {
		return Status;
	}

	public void setStatus(HistoryVoucherStatus status) {
		Status = status;
	}

	public String getVoucherCode() {
		return VoucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		VoucherCode = voucherCode;
	}

    
    
}
