package ru.bellintegrator.practice.citizenship.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class CitizenshipDaoImpl implements CitizenshipDao {
    private final EntityManager em;

    @Autowired
    public CitizenshipDaoImpl(EntityManager em) {
        this.em = em;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public CitizenshipEntity loadByCitizenshipCode(String citizenshipCode) {
        Query query = em.createQuery("select c from CitizenshipEntity as c where citizenship_code =?1", CitizenshipEntity.class);
                query.setParameter(1,citizenshipCode)
                        .setFirstResult(0)
                        .setMaxResults(1);
        CitizenshipEntity result = (CitizenshipEntity) query.getSingleResult();
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<CitizenshipEntity> all() {
        Query query = em.createNativeQuery("select * from Citizenship", CitizenshipEntity.class);
        List<CitizenshipEntity> result = query.getResultList();
        return result;
    }
}
