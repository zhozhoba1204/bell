package ru.bellintegrator.practice.office.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Контроллер для работы с Office
 */
@RestController
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * Вернуть список офисов по заданному фильтру
     * @param officeRequestDto
     * @return
     */
    @PostMapping("api/office/list")
    public List<OfficeResponseDto> filter(
            @RequestBody OfficeRequestDto officeRequestDto){
        List<OfficeResponseDto> result = officeService.filter(officeRequestDto);
        return result;
    }

    /**
     * Получить офис по id
     * @param id
     * @return
     */
    @GetMapping("api/office/{id}")
    public OfficeUpdateDto loadById(@PathVariable Integer id){
        OfficeUpdateDto result = officeService.loadById(id);
       return result;
    }

    /**
     * Изменить офис
     * @param officeUpdateDto
     * @return
     */
    @PostMapping("api/office/update")
    public Map<String,String> update(@RequestBody OfficeUpdateDto officeUpdateDto){
        officeService.update(officeUpdateDto);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
       return result;
    }

    /**
     * Сохранить новый офис
     * @param officeSaveDto
     * @return
     */
    @PostMapping("api/office/save")
    public Map<String,String> save(@RequestBody OfficeSaveDto officeSaveDto){
        officeService.save(officeSaveDto);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }
}
