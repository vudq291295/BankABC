package org.IntegrateService.PurchasePrepaidDataSIM.Configuration;

import org.IntegrateService.PurchasePrepaidDataSIM.Infrastructure.BaseCRUDRespositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryFactoryBean <R extends JpaRepository<T, I>, T,
I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I>{

	public BaseRepositoryFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
		// TODO Auto-generated constructor stub
	}

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new BaseRepositoryFactory(em);
    }
}
