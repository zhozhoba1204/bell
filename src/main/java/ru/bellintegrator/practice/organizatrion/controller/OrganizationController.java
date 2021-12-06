package ru.bellintegrator.practice.organizatrion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationRequestDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationResponseDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationSaveDto;
import ru.bellintegrator.practice.organizatrion.dto.OrganizationUpdateDto;
import ru.bellintegrator.practice.organizatrion.model.Organization;
import ru.bellintegrator.practice.organizatrion.service.OrganizationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("api/organization/list")
    public ResponseEntity<Map<String, List<OrganizationResponseDto>>> filter(
            @RequestBody OrganizationRequestDto organizationRequestDto){
        List<OrganizationResponseDto> result = organizationService.filter(organizationRequestDto);
       Map<String, List<OrganizationResponseDto>> map = new HashMap<>();
       map.put("data", result);
        return new ResponseEntity<Map<String, List<OrganizationResponseDto>>>(map, HttpStatus.OK);
    }

    @GetMapping("api/organization/{id}")
    public ResponseEntity<Map<String, OrganizationUpdateDto>> loadById(@PathVariable Integer id){
        OrganizationUpdateDto result = organizationService.loadById(id);
        Map<String, OrganizationUpdateDto> map = new HashMap<>();
        map.put("data", result);
        return new ResponseEntity<Map<String, OrganizationUpdateDto>>(map, HttpStatus.OK);
    }
    @PostMapping("api/organization/update")
    public ResponseEntity<Map> update(@RequestBody OrganizationUpdateDto organizationUpdateDto){
        organizationService.update(organizationUpdateDto);
        Map<String, String> map = new HashMap<>();
        map.put("result","succses");
        Map<String, Map> result = new HashMap<>();
        result.put("data", map);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }

    @PostMapping("api/organization/save")
    public ResponseEntity<Map> save(@RequestBody OrganizationSaveDto organizationSaveDto){
        organizationService.save(organizationSaveDto);
        Map<String, String> map = new HashMap<>();
        map.put("result","succses");
        Map<String, Map> result = new HashMap<>();
        result.put("data", map);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }
}
