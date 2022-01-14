package ru.bellintegrator.practice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.citizenship.dao.CitizenshipDao;
import ru.bellintegrator.practice.citizenship.model.Citizenship;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;
import ru.bellintegrator.practice.user.dto.UserSaveDto;
import ru.bellintegrator.practice.user.dto.UserUpdateDto;
import ru.bellintegrator.practice.user.model.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final CitizenshipDao citizenshipDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, CitizenshipDao citizenshipDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.citizenshipDao = citizenshipDao;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserResponseDto> filter(UserRequestDto userRequestDto) {
        List<User> daoList = userDao.filter(userRequestDto);
        return daoList.stream()
                .map(UserResponseDto::getResponseDtoFromUser)
                .collect(Collectors.toList());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public UserUpdateDto loadById(Integer id) {
        User user = userDao.loadById(id);
        UserUpdateDto result = UserUpdateDto.getUserFromUpdateDto(user);
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(UserUpdateDto userUpdateDto) {
        userDao.update(userUpdateDto);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void save(UserSaveDto userSaveDto) {
        Office office = officeDao.loadById(userSaveDto.officeId);
        Citizenship citizenship = citizenshipDao.loadByCitizenshipCode(userSaveDto.citizenshipCode);
        User user = UserSaveDto.getUserFromSaveDto(office, citizenship, userSaveDto);
        userDao.save(user);
    }
}
