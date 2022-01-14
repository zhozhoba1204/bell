package ru.bellintegrator.practice.user.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.citizenship.dao.CitizenshipDao;
import ru.bellintegrator.practice.documents.dao.DocumentDao;
import ru.bellintegrator.practice.documents.model.DocumentInfo;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.User;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao{
    private final OfficeDao officeDao;
    private final EntityManager em;
    private final DocumentDao documentDao;
    private final CitizenshipDao citizenshipDao;


    @Autowired
    public UserDaoImpl(OfficeDao officeDao, EntityManager em, DocumentDao documentDao,CitizenshipDao citizenshipDao) {
        this.officeDao = officeDao;
        this.em = em;
        this.documentDao = documentDao;
        this.citizenshipDao = citizenshipDao;
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
        Integer docCode = userRequestDto.docCode;
        String citizenshipCode = userRequestDto.citizenshipCode;

        Office office = officeDao.loadById(officeId);
        List<User> list = office.getUsers();
        if (firstName!=null){
            list = list.stream().filter(user->user.getFirstName().equals(firstName)).collect(Collectors.toList());
        }
        if (lastName!=null){
            list = list.stream().filter(user->user.getLastName().equals(lastName)).collect(Collectors.toList());
        }
        if (middleName!=null){
            list = list.stream().filter(user->user.getMiddleName().equals(middleName)).collect(Collectors.toList());
        }
        if (position!=null){
            list = list.stream().filter(user->user.getPosition().equals(position)).collect(Collectors.toList());
        }
        if (docCode!=null){
            List<DocumentInfo> documentInfo = documentDao.loadByDocumentType(docCode);
           List<User> users = new ArrayList<>();
            for (int i = 0; i<list.size();i++){
                User u = list.get(i);
                for (int j = 0; j<documentInfo.size(); j++){
                    if (u.getId().equals(documentInfo.get(j).getUser().getId())){
                        users.add(u);
                    }
                }
            }
            list = users;
        }
        if (citizenshipCode!=null){
            list = list.stream().filter(user->user.getCitizenship().equals(citizenshipDao.loadByCitizenshipCode(citizenshipCode))).collect(Collectors.toList());
        }
        return list;
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

        User user = em.find(User.class, userUpdateDto.id);
        if (userUpdateDto.officeId!=null){
        Office office = em.find(Office.class,userUpdateDto.officeId);
        user.setOffice(office);
        }

        user.setFirstName(userUpdateDto.firstName);

        if (userUpdateDto.secondName!=null) {
            user.setLastName(userUpdateDto.secondName);
        }
        if (userUpdateDto.middleName!=null) {
            user.setMiddleName(userUpdateDto.middleName);
        }

        user.setPosition(userUpdateDto.position);

        if (userUpdateDto.phone!=null) {
            user.setPhone(userUpdateDto.phone);
        }
        if (userUpdateDto.docNumber!=null){
            documentDao.updateDocNumber(userUpdateDto.id, userUpdateDto.docNumber);
        }
        if (userUpdateDto.docDate!=null){
            documentDao.updateDocDate(userUpdateDto.id, userUpdateDto.docDate);
        }
        if (userUpdateDto.docName!=null){
            documentDao.updateDocName(userUpdateDto.id, userUpdateDto.docName);
        }
        if (userUpdateDto.citizenshipCode!=null) {
            user.setCitizenship(citizenshipDao.loadByCitizenshipCode(userUpdateDto.citizenshipCode));
        }
        if (userUpdateDto.isIdentified) {
            user.setIsIdentified(userUpdateDto.isIdentified);
        }
        Session session = em.unwrap(Session.class);
        session.update(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }
}
