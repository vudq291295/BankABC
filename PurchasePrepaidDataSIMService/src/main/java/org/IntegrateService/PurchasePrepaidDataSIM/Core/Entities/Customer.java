package org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{
	
	@Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    @Column(name="phone_number",unique = true)
    @Size(min = 1, max = 13)
    private String PhoneNumber;
    
    @Column(name="name")
    @Size(max = 200)
    private String Name;

    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    private Set<HistoryPurchase> HistoryPurchase;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Set<HistoryPurchase> getHistoryPurchase() {
		return HistoryPurchase;
	}

	public void setHistoryPurchase(Set<HistoryPurchase> historyPurchase) {
		HistoryPurchase = historyPurchase;
	}

}
