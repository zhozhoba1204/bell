package ru.bellintegrator.practice.user.dto;

import ru.bellintegrator.practice.user.model.User;

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
      public static UserResponseDto getDtoFromUser(User user){
            return new UserResponseDto(user.getId(),
                    user.getFirstName(), user.getLastName(),
                    user.getMiddleName(), user.getPosition());
      }

      @Override
      public String toString() {
            return "UserResponseDto{" +
                    "id: " + id +
                    ", firstName: '" + firstName +
                    ", secondName: '" + secondName +
                    ", middleName: '" + middleName +
                    ", position: '" + position +
                    '}';
      }
}

