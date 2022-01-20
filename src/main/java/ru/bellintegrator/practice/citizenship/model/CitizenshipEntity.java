package ru.bellintegrator.practice.citizenship.model;

import ru.bellintegrator.practice.user.model.UserEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.List;

/**
 * Гражданство
 */
@Entity
@Table(name = "Citizenship")
public class CitizenshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Код страны
     */
    @Column(name = "citizenship_code", length = 50, nullable = false)
    private String citizenshipCode;

    /**
     * Наименование
     */
    @Column(name = "citizenship_name", length = 50, nullable = false)
    private String citizenshipName;

    /**
     * Список юзеров - граждан данной страны
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_id")
    private List<UserEntity> users;

    /**
     * Конструктор
     */
    public CitizenshipEntity() {
    }

    /**
     * Конструктор
     * @param citizenshipCode
     * @param citizenshipName
     */
    public CitizenshipEntity(String citizenshipCode, String citizenshipName) {
        this.citizenshipCode = citizenshipCode;
        this.citizenshipName = citizenshipName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
