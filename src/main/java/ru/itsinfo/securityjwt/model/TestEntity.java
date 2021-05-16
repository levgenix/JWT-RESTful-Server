package ru.itsinfo.securityjwt.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_entity")
@EqualsAndHashCode(callSuper = false)
@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class TestEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;

    public TestEntity(String name, String email, Boolean enabled) {
        this.name = name;
        this.email = email;
        this.enabled = enabled;
    }
}
