package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ru.bellintegrator.practice.office.dto.OfficeRequestDto;
import ru.bellintegrator.practice.office.dto.OfficeResponseDto;
import ru.bellintegrator.practice.office.dto.OfficeSaveDto;
import ru.bellintegrator.practice.office.dto.OfficeUpdateDto;
import ru.bellintegrator.practice.office.service.OfficeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("api/office/list")
    public ResponseEntity<Map<String, List<OfficeResponseDto>>> filter(
            @RequestBody OfficeRequestDto officeRequestDto){
        List<OfficeResponseDto> result = officeService.filter(officeRequestDto);
        Map<String, List<OfficeResponseDto>> map = new HashMap<>();
        map.put("data", result);
        return new ResponseEntity<Map<String, List<OfficeResponseDto>>>(map, HttpStatus.OK);
    }

    @GetMapping("api/office/{id}")
    public ResponseEntity<Map<String, OfficeUpdateDto>> loadById(@PathVariable Integer id){
        OfficeUpdateDto result = officeService.loadById(id);
        Map<String, OfficeUpdateDto> map = new HashMap<>();
        map.put("data", result);
        return new ResponseEntity<Map<String, OfficeUpdateDto>>(map, HttpStatus.OK);
    }

    @PostMapping("api/office/update")
    public ResponseEntity<Map> update(@RequestBody OfficeUpdateDto officeUpdateDto){
        officeService.update(officeUpdateDto);
        Map<String, String> map = new HashMap<>();
        map.put("result","succses");
        Map<String, Map> result = new HashMap<>();
        result.put("data", map);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }

    @PostMapping("api/office/save")
    public ResponseEntity<Map> save(@RequestBody OfficeSaveDto officeSaveDto){
        officeService.save(officeSaveDto);
        Map<String, String> map = new HashMap<>();
        map.put("result","succses");
        Map<String, Map> result = new HashMap<>();
        result.put("data", map);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }
}
