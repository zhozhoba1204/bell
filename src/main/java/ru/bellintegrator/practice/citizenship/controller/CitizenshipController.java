package ru.bellintegrator.practice.citizenship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.citizenship.dto.CitizenshipDto;
import ru.bellintegrator.practice.citizenship.service.CitizenshipService;
import java.util.List;

/**
 * Контроллер для работы с citizenship
 */
@RestController
public class CitizenshipController {
    private final CitizenshipService citizenshipService;

    @Autowired
    public CitizenshipController(CitizenshipService service) {
        this.citizenshipService = service;
    }

    /**
     *Получить справочник стран
     * @return список стран и их код
     */
    @PostMapping("api/countries")
    public List<CitizenshipDto> all(){
        List<CitizenshipDto> result = citizenshipService.all();
        return result;
    }
}
