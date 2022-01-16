package ru.bellintegrator.practice.user.dto;

import ru.bellintegrator.practice.citizenship.model.Citizenship;
import ru.bellintegrator.practice.documents.model.DocumentInfo;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.model.User;
import javax.validation.constraints.NotEmpty;

public class UserSaveDto {
    @NotEmpty(message = "id cannot be null")
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
    public boolean isIdentified;

    public UserSaveDto() {
    }

    public UserSaveDto(String firstName) {
        this.firstName = firstName;
    }

    public UserSaveDto(Integer officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, String citizenshipCode, boolean isIdentified) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public static User getUserFromSaveDto(Office office, Citizenship citizenship, UserSaveDto userSaveDto) {
        DocumentInfo documentInfo = new DocumentInfo(userSaveDto.docNumber, userSaveDto.docDate, userSaveDto.docName);
        return new User(userSaveDto.firstName, userSaveDto.middleName, userSaveDto.secondName,
                 userSaveDto.position, userSaveDto.phone, documentInfo, office, citizenship,
                userSaveDto.isIdentified);
    }
}
