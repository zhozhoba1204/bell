package ru.bellintegrator.practice.citizenship.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.citizenship.model.Citizenship;
import ru.bellintegrator.practice.documents.model.DocumentType;

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
    public Citizenship loadByCitizenshipCode(String citizenshipCode) {
        Query query = em.createQuery("select c from Citizenship as c where citizenship_code =?1", Citizenship.class);
                query.setParameter(1,citizenshipCode);
        Citizenship result = (Citizenship) query.getSingleResult();
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Citizenship> all() {
        Query query = em.createNativeQuery("select * from Citizenship", Citizenship.class);
        List<Citizenship> result = query.getResultList();
        return result;
    }
}
