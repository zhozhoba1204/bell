package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.organizatrion.model.Organization;
import ru.bellintegrator.practice.user.model.User;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
/**
 * Офис
 */
@Entity
@Table(name = "Office")
public class Office {
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
     * Название офиса
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Идентификатор организации
     */
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    /**
     * Адрес
     */
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 11, nullable = false)
    private String phone;

    /**
     * Список сотрудников
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "office_id")
    private List<User> users;

    /**
     * Статус активности
     */
    @Column(name = "is_active")
    private boolean isActive;

    /**
     * Конструктор для hibernate
     */
    public Office() {
    }

    /**
     * Конструктор
     */
    public Office(String name, Organization organization, String address, String phone, boolean isActive) {
        this.name = name;
        this.organization = organization;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
