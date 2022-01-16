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

    public UserUpdateDto(Integer id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

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

    public static UserUpdateDto getUpdateDtoFromUser(User user) {
        return new UserUpdateDto(user.getId(),user.getOffice().getId(), user.getFirstName(),user.getLastName(),
                user.getMiddleName(),user.getPosition(),user.getPhone(), user.getDocumentInfo().getDocName(),
                user.getDocumentInfo().getDocNumber(),user.getDocumentInfo().getDocDate(),user.getCitizenship().getCitizenshipCode(),
                user.asIdentified());
    }

    public Integer getId() {
        return id;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public boolean asIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(boolean identified) {
        isIdentified = identified;
    }
}
