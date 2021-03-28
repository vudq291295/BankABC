package org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Enums.StatusTypeVoucher;

@Entity
@Table(name = "type_voucher")
public class TypeVoucher extends BaseEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 200)
    private String name;

    @Column(name="price")
    private int Price;
    
    @Column(name="capacity")
    @Size(max = 200)
    private String Capacity;
    
    @Column(name="date_expire")
    private Date DateExpire;
    
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusTypeVoucher Status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public Date getDateExpire() {
		return DateExpire;
	}

	public void setDateExpire(Date dateExpire) {
		DateExpire = dateExpire;
	}

	public StatusTypeVoucher getStatus() {
		return Status;
	}

	public void setStatus(StatusTypeVoucher status) {
		Status = status;
	}
    
    
}
