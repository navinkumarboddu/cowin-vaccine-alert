package org.cowin.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.cowin.data.CowinPincodes;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CowinPincodeRepository implements PanacheRepository<CowinPincodes> {

}
