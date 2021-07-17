package org.cowin.service;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.cowin.data.CowinPincodes;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CowinPinCodesService {
	@Inject
	@PersistenceUnit
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<CowinPincodes> findAllCowinPincodes2() {
		Query query = em.createQuery("SELECT c FROM cowinpincodes c");
		return (Collection<CowinPincodes>) query.getResultList();
	}

	@Transactional(Transactional.TxType.SUPPORTS)
	public List<CowinPincodes> getCowinPincodes() {
		return CowinPincodes.listAll();
	}
	
}