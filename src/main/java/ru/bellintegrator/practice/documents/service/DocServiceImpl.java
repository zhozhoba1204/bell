package ru.bellintegrator.practice.documents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.documents.dao.DocumentDao;
import ru.bellintegrator.practice.documents.dto.DocumentDto;
import ru.bellintegrator.practice.documents.model.DocumentType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class DocServiceImpl implements DocService{
    private final DocumentDao documentDao;

    @Autowired
    public DocServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentDto> all() {
        List<DocumentType> list = documentDao.all();
        List<DocumentDto> result = list.stream()
                .map(DocumentDto::getDtoFromDocument)
                .collect(Collectors.toList());

        return result;
    }
}
