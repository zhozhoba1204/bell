package ru.bellintegrator.practice.organizatrion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDaoImpl;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.organizationDao = dao;
    }

    @Override
    public List<OrganizationResponseDto> filter(OrganizationRequestDto organizationRequestDto) {
        List<Organization> daoList = organizationDao.filter(organizationRequestDto);
        return daoList.stream()
                .map(OrganizationResponseDto::getDtoFromOrganization)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationUpdateDto loadById(Integer id) {
        Organization organization = organizationDao.loadById(id);
        OrganizationUpdateDto result = OrganizationUpdateDto.getUpdateDtoFromOrganization(organization);
        return result;
    }

    @Override
    public void update(OrganizationUpdateDto organizationUpdateDto) {
        organizationDao.update(organizationUpdateDto);
    }

    @Override
    public void save(OrganizationSaveDto organizationSaveDto) {
        Organization organization = OrganizationSaveDto.getOrganizationFromSaveDto(organizationSaveDto);
        organizationDao.save(organization);
    }

}
