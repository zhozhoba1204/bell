package ru.bellintegrator.practice.documents.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.documents.model.DocumentInfoEntity;
import ru.bellintegrator.practice.documents.model.DocumentTypeEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
/**
 * {@inheritDoc}
 */
@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager em;

    @Autowired
    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentTypeEntity loadByDocCode(Integer docCode) {
        Query query = em.createNativeQuery("select * from Document_type where doc_code =?1", DocumentTypeEntity.class);
        query.setParameter(1,docCode);
        DocumentTypeEntity result = (DocumentTypeEntity) query.getSingleResult();
      return result;
    }
    /**
     * {@inheritDoc}
     */
    public List<DocumentInfoEntity> loadByDocumentType(Integer docCode){
        DocumentTypeEntity documentType = loadByDocCode(docCode);
        Query query = em.createNativeQuery("select * from Document_info where doc_name =?1", DocumentInfoEntity.class);
        query.setParameter(1,documentType.getDocName());
        List<DocumentInfoEntity> result = query.getResultList();
        return result;
    }
    /**
     * {@inheritDoc}
     */
    public void updateDocNumber(Integer id, String docNumber){
        Query query = em.createNativeQuery("Update Document_info SET doc_number = ?2 where user_id = ?1");
        query.setParameter(1, id);
        query.setParameter(2,docNumber);
        query.executeUpdate();
    }
    /**
     * {@inheritDoc}
     */
    public void updateDocDate(Integer id, String docDate){
        Query query = em.createNativeQuery("Update Document_info SET doc_date = ?2 where user_id = ?1");
        query.setParameter(1, id);
        query.setParameter(2,docDate);
        query.executeUpdate();
    }
    /**
     * {@inheritDoc}
     */
    public void updateDocName(Integer id, String docName){
        Query query = em.createNativeQuery("Update Document_info SET doc_name = ?1 where user_id = ?2");
        query.setParameter(1,docName);
        query.setParameter(2, id);
        query.executeUpdate();
    }
    /**
     * {@inheritDoc}
     */
    public List<DocumentTypeEntity> all(){
        Query query = em.createNativeQuery("select * from Document_type", DocumentTypeEntity.class);
        List<DocumentTypeEntity> result = query.getResultList();
        return result;
    }
}
