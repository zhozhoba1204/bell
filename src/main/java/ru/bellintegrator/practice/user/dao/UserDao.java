package ru.bellintegrator.practice.user.dao;


import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.User;
import java.util.List;

/**
 * DAO для работы с Office
 */
public interface UserDao {

    /**
     * Получить все объекты Usr по фильтру
     *
     * @return
     */
    List<User> filter(UserRequestDto userRequestDto);

    /**
     * Получить Usr по идентификатору
     *
     * @param id
     * @return
     */
    User loadById(Integer id);

    /**
     * Редактировать Usr
     *
     * @param userUpdateDto
     */
    void update(UserUpdateDto userUpdateDto);

    /**
     * Сохранить Usr
     *
     * @param user
     */
    void save(User user);
}
