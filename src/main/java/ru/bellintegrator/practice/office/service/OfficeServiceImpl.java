package ru.bellintegrator.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDao;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import java.util.List;
import java.util.stream.Collectors;
/**
 * {@inheritDoc}
 */
@Service
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
    @Transactional
    public List<OfficeResponseDto> filter(OfficeRequestDto officeRequestDto) {
        List<Office> daoList = officeDao.filter(officeRequestDto);
        return daoList.stream()
                .map(OfficeResponseDto ::getResponceDtoFromOffice)
                .collect(Collectors.toList());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeUpdateDto loadById(Integer id) {
        Office office = officeDao.loadById(id);
        OfficeUpdateDto result = OfficeUpdateDto.getOfficeFromUpdateDto(office);
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(OfficeUpdateDto officeUpdateDto) {
        officeDao.update(officeUpdateDto);
    }
    /**
     * {@inheritDoc}
     */
    @Transactional
    public void save(OfficeSaveDto officeSaveDto){
        Organization organization = organizationDao.loadById(officeSaveDto.orgId);
        Office office = OfficeSaveDto.getOfficeFromSaveDto(organization, officeSaveDto);
        organization.getOffices().add(office);
        officeDao.save(office);
    }

}
