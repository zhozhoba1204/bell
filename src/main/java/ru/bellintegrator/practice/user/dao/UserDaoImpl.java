package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.User;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class UserDaoImpl implements UserDao{
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> filter(UserRequestDto userRequestDto) {
        Integer officeId = userRequestDto.officeId;
        String firstName = userRequestDto.firstName;
        String lastName = userRequestDto.lastName;
        String middleName = userRequestDto.middleName;
        String position = userRequestDto.position;
        String docCode = userRequestDto.docCode;
        String citizenshipCode = userRequestDto.citizenshipCode;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Organization> root = criteriaQuery.from(User.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(
                criteriaBuilder.equal(root.get("officeId"), officeId));
        if (firstName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("middleName"), middleName));
        }
        if (position != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("position"), position));
        }
        if (docCode != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("docCode"), docCode));
        }
        if (citizenshipCode != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("citizenshipCode"), citizenshipCode));
        }


        Predicate [] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
        criteriaQuery.select(root).where(predicatesarr);

        List<User> result = em.createQuery(criteriaQuery).getResultList();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadById(Integer id) {
        return em.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(UserUpdateDto userUpdateDto) {
        Integer id = userUpdateDto.id;
        Integer officeId = userUpdateDto.officeId;
        String firstName = userUpdateDto.firstName;
        String secondName = userUpdateDto.secondName;//lastName??
        String middleName = userUpdateDto.middleName;
        String position = userUpdateDto.position;
        String phone = userUpdateDto.phone;
        String docName = userUpdateDto.docName;
        String docNumber = userUpdateDto.docNumber;
        String docDate = userUpdateDto.docDate;
        String citizenshipCode = userUpdateDto.citizenshipCode;
        boolean isIdentifier = userUpdateDto.isIdentifier;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Organization> root = criteriaQuery.from(User.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(
                criteriaBuilder.equal(root.get("id"), id));
        if (officeId != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("officeId"), officeId));
        }
        predicates.add(criteriaBuilder.equal(root.get("firstName"), firstName));
        if (secondName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("secondName"), secondName));
        }
        if (middleName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("middleName"), middleName));
        }
        predicates.add(criteriaBuilder.equal(root.get("position"), position));
        if (docName != null) {
            predicates.add(
                    criteriaBuilder.equal(root.get("docName"), docName));
            if (docNumber != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("docNumber"), docNumber));
            }
            if (docDate != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("docDate"), docDate));
            }
            if (citizenshipCode != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("citizenshipCode"), citizenshipCode));
            }
            if ((isIdentifier)) {
                predicates.add(criteriaBuilder.equal(root.get("isIdentifier"), isIdentifier));
            }

            Predicate[] predicatesarr = predicates.toArray(new Predicate[predicates.size()]);
            criteriaQuery.select(root).where(predicatesarr);

            int result = em.createQuery(criteriaQuery).executeUpdate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }
}
