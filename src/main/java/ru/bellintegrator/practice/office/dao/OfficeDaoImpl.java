package ru.bellintegrator.practice.office.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;
/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private OrganizationDao organizationDao;
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
    public List<Office> filter(OfficeRequestDto officeRequestDto) {
        Integer orgId = officeRequestDto.orgId;
        String name = officeRequestDto.name;
        String phone = officeRequestDto.phone;
        boolean isActive = officeRequestDto.isActive;

        Organization organization = organizationDao.loadById(orgId);
        List<Office> list = organization.getOffices();
        if (name!=null){
            list = (List<Office>) list.stream().filter(office->office.getName().equals(name)).collect(Collectors.toList());
        }
        if (isActive){
           list = list.stream().filter(office -> isActive == office.isActive()).collect(Collectors.toList());
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Integer id) {
        return em.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OfficeUpdateDto officeUpdateDto) {
        Office of = em.find(Office.class, officeUpdateDto.id);
        of.setName(officeUpdateDto.name);
        of.setAddress(officeUpdateDto.address);
        if (officeUpdateDto.phone!=null) {
            of.setPhone(officeUpdateDto.phone);
        }
        if (officeUpdateDto.isActive && officeUpdateDto.isActive!=of.isActive()) {
            of.setActive(officeUpdateDto.isActive);
        }
        Session session = em.unwrap(Session.class);
        session.update(of);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }
}
