package ru.bellintegrator.practice.user.dto;

import javax.validation.constraints.NotEmpty;

public class UserRequestDto {
      @NotEmpty(message = "officeId cannot be null")
      public Integer officeId;
      public String firstName;
      public String lastName;
      public String middleName;
      public String position;
      public String docCode;
      public String citizenshipCode;
}
