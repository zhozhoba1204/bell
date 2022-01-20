package ru.bellintegrator.practice.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.OfficeEntity;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final OrganizationDao organizationDao;
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em, OrganizationDao organizationDao){
        this.em = em;
        this.organizationDao = organizationDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OfficeEntity> filter(OfficeRequestDto officeRequestDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OfficeEntity> criteriaQuery = cb.createQuery(OfficeEntity.class);
        Root<OfficeEntity> officeRoot = criteriaQuery.from(OfficeEntity.class);
        Root<OrganizationEntity> organizationRoot = criteriaQuery.from(OrganizationEntity.class);

        List<Predicate> officePredicates = new ArrayList<>();
        officePredicates.add(cb.equal(
                organizationRoot.get("id"), officeRequestDto.getOrgId()));
        Optional.ofNullable(officeRequestDto.getName()).ifPresent(name -> officePredicates.add(
                cb.equal(officeRoot.get("name"), name)));
        Optional.ofNullable(officeRequestDto.getPhone()).ifPresent(phone -> officePredicates
                .add(cb.equal(officeRoot.get("phone"), phone)));

        Optional.ofNullable(officeRequestDto.asActive()).ifPresent(isActive -> officePredicates.add(
                    cb.equal(officeRoot.get("isActive"), isActive)));

        Predicate[] predicates = officePredicates.toArray(new Predicate[officePredicates.size()]);
        criteriaQuery.select(officeRoot).where(predicates);

        return em.createQuery(criteriaQuery).getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeEntity loadById(Integer id) {
        return em.find(OfficeEntity.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OfficeUpdateDto officeUpdateDto) {
        OfficeEntity office = em.find(OfficeEntity.class, officeUpdateDto.id);
        office.setName(officeUpdateDto.name);
        office.setAddress(officeUpdateDto.address);
        if (officeUpdateDto.phone!=null) {
            office.setPhone(officeUpdateDto.phone);
        }
        if (officeUpdateDto.isActive && officeUpdateDto.isActive!=office.asActive()) {
            office.setIsActive(officeUpdateDto.isActive);
        }
        em.merge(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OfficeEntity office) {
        em.persist(office);
    }
}
