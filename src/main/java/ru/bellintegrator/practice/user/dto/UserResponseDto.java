package ru.bellintegrator.practice.user.dto;

import ru.bellintegrator.practice.user.model.UserEntity;

public class UserResponseDto {
      public Integer id;
      public String firstName;
      public String secondName;
      public String middleName;
      public String position;

      public UserResponseDto(Integer id, String firstName, String secondName, String middleName, String position) {
            this.id = id;
            this.firstName = firstName;
            this.secondName = secondName;
            this.middleName = middleName;
            this.position = position;
      }
      public static UserResponseDto getDtoFromUser(UserEntity user){
            return new UserResponseDto(user.getId(),
                    user.getFirstName(), user.getLastName(),
                    user.getMiddleName(), user.getPosition());
      }

      public static UserResponseDto getResponseDtoFromUser(UserEntity user) {
            return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getMiddleName(),
                    user.getPosition());
      }

      public Integer getId() {
            return id;
      }

      public String getFirstName() {
            return firstName;
      }

      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }

      public String getSecondName() {
            return secondName;
      }

      public void setSecondName(String secondName) {
            this.secondName = secondName;
      }

      public String getMiddleName() {
            return middleName;
      }

      public void setMiddleName(String middleName) {
            this.middleName = middleName;
      }

      public String getPosition() {
            return position;
      }

      public void setPosition(String position) {
            this.position = position;
      }
}

