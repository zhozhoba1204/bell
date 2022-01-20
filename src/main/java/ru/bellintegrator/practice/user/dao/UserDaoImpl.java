package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.citizenship.dao.CitizenshipDao;
import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;
import ru.bellintegrator.practice.documents.dao.DocumentDao;
import ru.bellintegrator.practice.documents.model.DocumentTypeEntity;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.OfficeEntity;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.UserEntity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {
    private final OfficeDao officeDao;
    private final EntityManager em;
    private final DocumentDao documentDao;
    private final CitizenshipDao citizenshipDao;


    @Autowired
    public UserDaoImpl(OfficeDao officeDao, EntityManager em, DocumentDao documentDao, CitizenshipDao citizenshipDao) {
        this.officeDao = officeDao;
        this.em = em;
        this.documentDao = documentDao;
        this.citizenshipDao = citizenshipDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserEntity> filter(UserRequestDto userRequestDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = cb.createQuery(UserEntity.class);
        Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);
        Root<OfficeEntity> officeRoot = criteriaQuery.from(OfficeEntity.class);
        Root<DocumentTypeEntity> documentTypeRoot = criteriaQuery.from(DocumentTypeEntity.class);
        Root<CitizenshipEntity> citizenshipRoot = criteriaQuery.from(CitizenshipEntity.class);

        List<Predicate> userPredicates = new ArrayList<>();

        userPredicates.add(cb.equal(
                officeRoot.get("id"), userRequestDto.officeId));
        Optional.ofNullable(userRequestDto.firstName).ifPresent(firstName -> userPredicates.add(
                cb.equal(userRoot.get("firstName"), firstName)));
        Optional.ofNullable(userRequestDto.middleName).ifPresent(middleName -> userPredicates.add(
                cb.equal(userRoot.get("middleName"), middleName)));
        Optional.ofNullable(userRequestDto.lastName).ifPresent(lastName -> userPredicates.add(
                cb.equal(userRoot.get("lastName"), lastName)));
        Optional.ofNullable(userRequestDto.position).ifPresent(position -> userPredicates.add(
                cb.equal(userRoot.get("position"), position)));
        Optional.ofNullable(userRequestDto.docCode).ifPresent(docCode -> userPredicates
                .add(cb.equal(documentTypeRoot.get("docCode"), docCode)));
        Optional.ofNullable(userRequestDto.citizenshipCode).ifPresent(citizenshipCode -> userPredicates
                .add(cb.equal(citizenshipRoot.get("citizenshipCode"), citizenshipCode)));

        Predicate[] predicates = userPredicates.toArray(new Predicate[userPredicates.size()]);
        criteriaQuery.select(userRoot).where(predicates);

        return em.createQuery(criteriaQuery).getResultList()
                .stream().distinct().collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity loadById(Integer id) {
        return em.find(UserEntity.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(UserUpdateDto userUpdateDto) {
        UserEntity user = em.find(UserEntity.class, userUpdateDto.id);

        Optional.ofNullable(userUpdateDto.officeId)
                .ifPresent(officeId -> user.setOffice(em.find(OfficeEntity.class, userUpdateDto.officeId)));

        user.setFirstName(userUpdateDto.firstName);

        Optional.ofNullable(userUpdateDto.secondName)
                .ifPresent(secondName -> user.setLastName(userUpdateDto.secondName));
        Optional.ofNullable(userUpdateDto.middleName)
                .ifPresent(middleName -> user.setMiddleName(userUpdateDto.middleName));

        user.setPosition(userUpdateDto.position);

        Optional.ofNullable(userUpdateDto.phone)
                .ifPresent(phone -> user.setPhone(userUpdateDto.phone));
        Optional.ofNullable(userUpdateDto.docNumber)
                .ifPresent(docNumber ->documentDao.updateDocNumber(userUpdateDto.id, userUpdateDto.docNumber));
        Optional.ofNullable(userUpdateDto.docDate)
                .ifPresent(docDate -> documentDao.updateDocDate(userUpdateDto.id, userUpdateDto.docDate));
        Optional.ofNullable(userUpdateDto.docName)
                .ifPresent(docName -> documentDao.updateDocName(userUpdateDto.id, userUpdateDto.docName));
        Optional.ofNullable(userUpdateDto.citizenshipCode)
                .ifPresent(citizenshipCode -> user.setCitizenship(citizenshipDao.loadByCitizenshipCode(userUpdateDto.citizenshipCode)));
        Optional.of(userUpdateDto.isIdentified)
                .ifPresent(isIdentified -> user.setIsIdentified(userUpdateDto.isIdentified));
        em.merge(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(UserEntity user) {
        em.persist(user);
    }
}
