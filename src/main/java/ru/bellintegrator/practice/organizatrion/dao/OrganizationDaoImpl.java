package ru.bellintegrator.practice.organizatrion.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> filter(OrganizationRequestDto organizationRequestDto) {
        String name = organizationRequestDto.name;
        String inn = organizationRequestDto.inn;
        boolean isActive = organizationRequestDto.isActive;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Organization> root = criteriaQuery.from(Organization.class);

        List<Predicate> predicates = new ArrayList<>();
            predicates.add(
                    criteriaBuilder.equal(root.get("name"), name));
        if (inn != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("inn"), inn));
        }
        if (isActive) {
            predicates.add(
                    criteriaBuilder.equal(root.get("isActive"), isActive));
        }

        Predicate [] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        criteriaQuery.select(root).where(predicatesarr);

        List<Organization> result = em.createQuery(criteriaQuery).getResultList();
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Integer id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OrganizationUpdateDto organization) {
        Organization org = em.find(Organization.class, organization.id);
        org.setName(organization.name);
        org.setFullName(organization.fullName);
        org.setInn(organization.inn);
        org.setKpp(organization.kpp);
        org.setAddress(organization.address);
        if (organization.phone!=null) {
            org.setPhone(organization.phone);
        }
        if (organization.isActive && organization.isActive!=org.asActive()) {
            org.setIsActive(organization.isActive);
        }
        Session session = em.unwrap(Session.class);
        session.update(org);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }
}
