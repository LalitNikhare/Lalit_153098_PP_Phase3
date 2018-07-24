
package com.cg.mypaymentapp.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	private EntityManagerFactory factory;
	private EntityManager entityManager;

	{
		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}

	public EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public WalletRepoImpl() {
		entityManager = getEntityManager();
	}

	public boolean save(Customer customer) {
		try {

			entityManager.persist(customer);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Customer findOne(String mobileNo) {
		Customer customer = entityManager.find(Customer.class, mobileNo);
		// Wallet wallet = null;
		if (customer == null)
			return null;
		return customer;
	}

	@Override
	public Boolean update(Customer customer) {
		entityManager.merge(customer);
		return true;
	}

	@Override
	public void startTransaction() {
		entityManager.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}
}
