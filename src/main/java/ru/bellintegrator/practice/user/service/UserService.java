package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;
import ru.bellintegrator.practice.user.dto.UserSaveDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import java.util.List;

/**
 * Сервисный слой бизнес-логики с User
 */
public interface UserService {
    /**
     * Получить всех юзеров по фильтру
     * @param userRequestDto
     * @return
     */
    List<UserResponseDto> filter(UserRequestDto userRequestDto);

    /**
     * Получить юзера по id
     * @param id
     * @return
     */
    UserUpdateDto loadById(Integer id);

    /**
     * Изменить юзера
     * @param userUpdateDto
     */
    void update(UserUpdateDto userUpdateDto);

    /**
     * Сохранить юзера
     * @param userSaveDto
     */
    void save(UserSaveDto userSaveDto);
}
