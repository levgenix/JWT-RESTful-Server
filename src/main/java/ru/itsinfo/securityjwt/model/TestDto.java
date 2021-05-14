package ru.itsinfo.securityjwt.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_dto")
public class TestDto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Boolean enabled;

    public TestDto(String email, Boolean enabled) {
        this.email = email;
        this.enabled = enabled;
    }

    public TestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
