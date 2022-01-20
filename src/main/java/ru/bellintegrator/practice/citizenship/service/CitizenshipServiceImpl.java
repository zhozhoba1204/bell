package ru.bellintegrator.practice.citizenship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.citizenship.dao.CitizenshipDao;
import ru.bellintegrator.practice.citizenship.dto.CitizenshipDto;
import ru.bellintegrator.practice.citizenship.model.CitizenshipEntity;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class CitizenshipServiceImpl implements CitizenshipService{
    private final CitizenshipDao citizenshipDao;

    @Autowired
    public CitizenshipServiceImpl(CitizenshipDao citizenshipDao) {
        this.citizenshipDao = citizenshipDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CitizenshipDto> all() {
        List<CitizenshipEntity> list = citizenshipDao.all();
        List<CitizenshipDto> result = list.stream()
                .map(CitizenshipDto::getDtoFromCitizenship)
                .collect(Collectors.toList());

        return result;
    }
}
