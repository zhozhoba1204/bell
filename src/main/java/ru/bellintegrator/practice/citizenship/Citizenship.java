package ru.bellintegrator.practice.citizenship;

import ru.bellintegrator.practice.user.model.User;
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
public class Citizenship {
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
     * Код
     */
    @Column(name = "citizenship_code", length = 50, nullable = false)
    private String citizenshipCode;

    /**
     * Наименование
     */
    @Column(name = "citizenship_name", length = 50, nullable = false)
    private String citizenshipName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizenship_id")
    private List<User> users;
}
