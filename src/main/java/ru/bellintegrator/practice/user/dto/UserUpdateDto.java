package ru.bellintegrator.practice.user.dto;

import javax.validation.constraints.NotEmpty;

public class UserUpdateDto {
    @NotEmpty(message = "id cannot be null")
    public Integer id;
    public Integer officeId;
    @NotEmpty(message = "firstName cannot be null")
    public String firstName;
    public String secondName;
    public String middleName;
    @NotEmpty(message = "position cannot be null")
    public String position;
    public String phone;
    public String docName;
    public String docNumber;
    public String docDate;
    public String citizenshipCode;
    public boolean isIdentifier;


}
