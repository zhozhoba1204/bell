package ru.bellintegrator.practice.user.dto;

import ru.bellintegrator.practice.user.model.User;
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
    public boolean isIdentified;

    public UserUpdateDto(Integer id, Integer officeId, String firstName, String secondName, String middleName, String position, String phone, String docName, String docNumber, String docDate, String citizenshipCode, boolean isIdentified) {
        this.id = id;
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

    public static UserUpdateDto getUserFromUpdateDto(User user) {
        return new UserUpdateDto(user.getId(),user.getOffice().getId(), user.getFirstName(),user.getLastName(),
                user.getMiddleName(),user.getPosition(),user.getPhone(), user.getDocumentInfo().getDocName(),
                user.getDocumentInfo().getDocNumber(),user.getDocumentInfo().getDocDate(),user.getCitizenship().getCitizenshipCode(),
                user.isIdentified());
    }
}
