package ru.bellintegrator.practice.user.service;

import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;
import ru.bellintegrator.practice.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    
    @Override
    public List<UserResponseDto> getUserByFilter(UserRequestDto userRequestDto) {
        List<User> daoList = userDao.filter(userRequestDto);
        return daoList.stream()
                .map(UserResponseDto ::getDtoFromUser)
                .collect(Collectors.toList());
    }
}
