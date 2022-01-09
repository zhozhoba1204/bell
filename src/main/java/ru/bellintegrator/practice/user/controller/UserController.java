package ru.bellintegrator.practice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;
import ru.bellintegrator.practice.user.dto.UserSaveDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Контроллер для работы с User
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получить список юзеров по заданному фильтру
     * @param userRequestDto
     * @return
     */
    @PostMapping("/list")
    public List<UserResponseDto> filter(@RequestBody UserRequestDto userRequestDto){
        List<UserResponseDto> result = userService.filter(userRequestDto);
        return result;
    }

    /**
     * Получить юзера по id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
        public UserUpdateDto loadById(@PathVariable Integer id){
        UserUpdateDto result = userService.loadById(id);
        return result;
    }

    /**
     * Изменить юзера
     * @param userUpdateDto
     * @return
     */
    @PostMapping("/update")
    public Map<String, String> update(@RequestBody UserUpdateDto userUpdateDto){
        userService.update(userUpdateDto);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }

    /**
     * Сохранить нового юзера
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Map<String, String> saveUser(@RequestBody UserSaveDto user) {
        userService.save(user);
        Map<String, String> result = new HashMap<>();
        result.put("result","success");
        return result;
    }

}
