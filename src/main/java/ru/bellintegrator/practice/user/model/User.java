package ru.bellintegrator.practice.user.model;


import javax.persistence.*;

/**
 * Пользователь
 */

@Entity
@Table(name = "Usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Имя
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    /**
     * Фамилия
     */
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    /**
     * Должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * Номер телефона
     */
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;


    /**
     * Конструктор для hibernate
     */
    public User() {
    }

    /**
     * Конструктор
     */
    public User(String firstName, String middleName, String lastName, String position, String phone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.position = position;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
