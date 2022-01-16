package ru.bellintegrator.practice.user.dto;

import javax.validation.constraints.NotEmpty;

public class UserRequestDto {
      @NotEmpty(message = "officeId cannot be null")
      public Integer officeId;
      public String firstName;
      public String middleName;
      public String lastName;
      public String position;
      public Integer docCode;
      public String citizenshipCode;

      public UserRequestDto() {
      }

      public UserRequestDto(Integer officeId) {
            this.officeId = officeId;
      }

      public UserRequestDto(Integer officeId, String firstName, String middleName, String lastName, String position) {
            this.officeId = officeId;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.position = position;
      }

      public UserRequestDto(Integer officeId, String firstName, String middleName, String lastName, String position, Integer docCode, String citizenshipCode) {
            this.officeId = officeId;
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.position = position;
            this.docCode = docCode;
            this.citizenshipCode = citizenshipCode;
      }

      public Integer getOfficeId() {
            return officeId;
      }

      public String getFirstName() {
            return firstName;
      }

      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }

      public String getLastName() {
            return lastName;
      }

      public void setLastName(String lastName) {
            this.lastName = lastName;
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

      public Integer getDocCode() {
            return docCode;
      }

      public void setDocCode(Integer docCode) {
            this.docCode = docCode;
      }

      public String getCitizenshipCode() {
            return citizenshipCode;
      }

      public void setCitizenshipCode(String citizenshipCode) {
            this.citizenshipCode = citizenshipCode;
      }
}
