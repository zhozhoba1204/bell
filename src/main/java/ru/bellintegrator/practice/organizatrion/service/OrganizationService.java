package ru.bellintegrator.practice.organizatrion.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.organizatrion.dao.OrganizationDaoImpl;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import java.util.List;
import java.util.stream.Stream;

public interface OrganizationService {
    List<OrganizationResponseDto> filter(OrganizationRequestDto organizationRequestDto);

    OrganizationUpdateDto loadById(Integer id);

    void update(OrganizationUpdateDto organizationUpdateDto);

    void save(OrganizationSaveDto organizationSaveDto);
}
