package org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.IntegrateService.PurchasePrepaidDataSIM.Core.Interface.IBaseCRUDRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class BaseCRUDRespositoryImpl<T,  ID extends Serializable> extends SimpleJpaRepository<T, ID >  implements IBaseCRUDRespository<T, ID>{
	
	private EntityManager entityManager;

	public BaseCRUDRespositoryImpl(Class<T> domainClass,EntityManager entityManager) {
		super(domainClass,entityManager);
		this.entityManager = entityManager;

	}
	
    @Transactional
    @Override
	public T findOne(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}



}
