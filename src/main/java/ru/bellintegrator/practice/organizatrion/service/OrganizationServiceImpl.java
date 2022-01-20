package ru.bellintegrator.practice.organizatrion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import java.util.List;
import java.util.stream.Collectors;
/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.organizationDao = dao;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationResponseDto> filter(OrganizationRequestDto organizationRequestDto) {
        List<OrganizationEntity> daoList = organizationDao.filter(organizationRequestDto);
        return daoList.stream()
                .map(OrganizationResponseDto::getDtoFromOrganization)
                .collect(Collectors.toList());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationUpdateDto loadById(Integer id) {
        OrganizationEntity organization = organizationDao.loadById(id);
        OrganizationUpdateDto result = OrganizationUpdateDto.getUpdateDtoFromOrganization(organization);
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OrganizationUpdateDto organizationUpdateDto) {
        organizationDao.update(organizationUpdateDto);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OrganizationSaveDto organizationSaveDto) {
        OrganizationEntity organization = OrganizationSaveDto.getOrganizationFromSaveDto(organizationSaveDto);
        organizationDao.save(organization);
    }

}
