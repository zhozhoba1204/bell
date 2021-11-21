package ru.bellintegrator.practice.office.model;


import ru.bellintegrator.practice.organizatrion.model.Organization;

import javax.persistence.*;

/**
 * Офис
 */
@Entity
@Table(name = "Office")
public class Office {
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
     * Название офиса
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

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
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    /**
     * Конструктор для hibernate
     */
    public Office() {
    }

    /**
     * Конструктор
     */
    public Office(String name, Organization organization, String address, String phone) {
        this.name = name;
        this.organization = organization;
        this.address = address;
        this.phone = phone;
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

    public Long getId() {
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
}
