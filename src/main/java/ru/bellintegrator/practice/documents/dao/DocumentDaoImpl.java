package ru.bellintegrator.practice.documents.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.documents.model.DocumentInfo;
import ru.bellintegrator.practice.documents.model.DocumentType;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.print.Doc;
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
    public DocumentType loadByDocCode(Integer docCode) {
        Query query = em.createNativeQuery("select * from Document_type where doc_code =?1", DocumentType.class);
        query.setParameter(1,docCode);
        DocumentType result = (DocumentType) query.getSingleResult();
      return result;
    }
    /**
     * {@inheritDoc}
     */
    public List<DocumentInfo> loadByDocumentType(Integer docCode){
        DocumentType documentType = loadByDocCode(docCode);
        Query query = em.createNativeQuery("select * from Document_info where doc_name =?1", DocumentInfo.class);
        query.setParameter(1,documentType.getDocName());
        List<DocumentInfo> result = query.getResultList();
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
    public List<DocumentType> all(){
        Query query = em.createNativeQuery("select * from Document_type", DocumentType.class);
        List<DocumentType> result = query.getResultList();
        return result;
    }
}
