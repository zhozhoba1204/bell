package ru.bellintegrator.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.OfficeEntity;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.model.OrganizationEntity;
import java.util.List;
import java.util.stream.Collectors;
/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService{

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<OfficeResponseDto> filter(OfficeRequestDto officeRequestDto) {
        List<OfficeEntity> daoList = officeDao.filter(officeRequestDto);
        return daoList.stream()
                .map(OfficeResponseDto ::getResponseDtoFromOffice)
                .collect(Collectors.toList());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeUpdateDto loadById(Integer id) {
        OfficeEntity office = officeDao.loadById(id);
        OfficeUpdateDto result = OfficeUpdateDto.getUpdateDtoFromOffice(office);
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(OfficeUpdateDto officeUpdateDto) {
        officeDao.update(officeUpdateDto);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OfficeSaveDto officeSaveDto){
        OrganizationEntity organization = organizationDao.loadById(officeSaveDto.orgId);
        OfficeEntity office = OfficeSaveDto.getOfficeFromSaveDto(organization, officeSaveDto);
        organization.getOffices().add(office);
        officeDao.save(office);
    }

}
