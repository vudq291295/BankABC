package org.IntegrateService.PurchasePrepaidDataSIM.Configuration;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.BaseCRUDRespositoryImpl;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

public class BaseRepositoryFactory <T, I extends Serializable>
extends JpaRepositoryFactory{
	
	private final EntityManager em;

	public BaseRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		em = entityManager;
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager em) {
		return new BaseCRUDRespositoryImpl<T, I>((Class<T>) information.getDomainType(), em);
	}
	
	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
	    return BaseCRUDRespositoryImpl.class;
	}

	public EntityManager getEm() {
		return em;
	}
}
