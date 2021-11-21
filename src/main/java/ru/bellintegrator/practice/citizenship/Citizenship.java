package ru.bellintegrator.practice.citizenship;

import javax.persistence.*;

/**
 * Гражданство
 */
@Entity
@Table(name = "Citizenship")
public class Citizenship {
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
     * Код
     */
    @Column(name = "citizenship_code", length = 50, nullable = false)
    private String citizenshipCode;

    /**
     * Наименование
     */
    @Column(name = "citizenship_name", length = 50, nullable = false)
    private String citizenshipName;
}
