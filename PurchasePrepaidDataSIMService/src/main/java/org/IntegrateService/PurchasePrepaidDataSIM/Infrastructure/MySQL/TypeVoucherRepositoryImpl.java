package org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.MySQL;

import javax.persistence.EntityManager;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Entities.TypeVoucher;
import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.MySQLRepository.ITypeVoucherRepository;
import org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.BaseCRUDRespositoryImpl;

public class TypeVoucherRepositoryImpl extends BaseCRUDRespositoryImpl<TypeVoucher, Long> implements ITypeVoucherRepository{

	public TypeVoucherRepositoryImpl(Class<TypeVoucher> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		// TODO Auto-generated constructor stub
	}

}
