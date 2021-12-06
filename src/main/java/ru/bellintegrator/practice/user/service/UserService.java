package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.dto.UserRequestDto;
import ru.bellintegrator.practice.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> getUserByFilter(UserRequestDto userRequestDto);
}
