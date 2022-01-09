package ru.bellintegrator.practice.organizatrion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.service.OrganizationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Контроллер для работы с Organization
 */
@RestController()
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получить список организаций по заданному фильтру
     * @param organizationRequestDto
     * @return
     */
    @PostMapping("api/organization/list")
    public List<OrganizationResponseDto> filter(
            @RequestBody OrganizationRequestDto organizationRequestDto){
        List<OrganizationResponseDto> result = organizationService.filter(organizationRequestDto);
        return result;
    }

    /**
     * Получить организацию по id
     * @param id
     * @return
     */
    @GetMapping("api/organization/{id}")
    public OrganizationUpdateDto loadById(@PathVariable Integer id){
        OrganizationUpdateDto result = organizationService.loadById(id);
        return result;
    }

    /**
     * Изменить организацию
     * @param organizationUpdateDto
     * @return
     */
    @PostMapping("api/organization/update")
    public Map<String, String> update(@RequestBody OrganizationUpdateDto organizationUpdateDto){
        organizationService.update(organizationUpdateDto);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }

    /**
     * Сохранить новую организацию
     * @param organizationSaveDto
     * @return
     */
    @PostMapping("api/organization/save")
    public Map<String, String> save(@RequestBody OrganizationSaveDto organizationSaveDto){
        organizationService.save(organizationSaveDto);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }
}
