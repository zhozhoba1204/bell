package ru.bellintegrator.practice.organizatrion.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<OrganizationEntity> filter(OrganizationRequestDto organizationRequestDto) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OrganizationEntity> criteriaQuery = cb.createQuery(OrganizationEntity.class);
        Root<OrganizationEntity> root = criteriaQuery.from(OrganizationEntity.class);

        List<Predicate> orgPredicates = new ArrayList<>();
            orgPredicates.add(
                    cb.equal(root.get("name"), organizationRequestDto.name));
        Optional.ofNullable(organizationRequestDto.getInn()).ifPresent(inn -> orgPredicates
                .add(cb.equal(root.get("inn"), inn)));

        Optional.ofNullable(organizationRequestDto.asActive()).ifPresent(isActive -> orgPredicates.add(
                cb.equal(root.get("isActive"), isActive)));
        Predicate [] predicates = orgPredicates.toArray(new Predicate[orgPredicates.size()]);
        criteriaQuery.select(root).where(predicates);

        List<OrganizationEntity> result = em.createQuery(criteriaQuery).getResultList();
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationEntity loadById(Integer id) {
        return em.find(OrganizationEntity.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OrganizationUpdateDto organization) {
        OrganizationEntity org = em.find(OrganizationEntity.class, organization.id);
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
        em.merge(org);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OrganizationEntity organization) {
        em.persist(organization);
    }
}
