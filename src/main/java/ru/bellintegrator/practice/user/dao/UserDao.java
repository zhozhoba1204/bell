package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.User;
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
    List<User> filter(UserRequestDto userRequestDto);

    /**
     * Получить юзера по id
     *
     * @param id
     * @return
     */
    User loadById(Integer id);

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
    void save(User user);
}
