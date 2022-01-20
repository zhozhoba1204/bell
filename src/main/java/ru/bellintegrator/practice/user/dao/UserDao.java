package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.UserEntity;
import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {

    /**
     * Получить всех юзеров по фильтру
     *
     * @return
     */
    List<UserEntity> filter(UserRequestDto userRequestDto);

    /**
     * Получить юзера по id
     *
     * @param id
     * @return
     */
    UserEntity loadById(Integer id);

    /**
     * Редактировать юзера
     *
     * @param userUpdateDto
     */
    void update(UserUpdateDto userUpdateDto);

    /**
     * Сохранить юзера
     *
     * @param user
     */
    void save(UserEntity user);
}
