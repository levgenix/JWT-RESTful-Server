package ru.itsinfo.securityjwt.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public final class ApplicationGrantedAuthority extends AbstractEntity implements GrantedAuthority {

    @Column(name = "role", unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<ApplicationUser> users = new ArrayList<>();

    public ApplicationGrantedAuthority() {
    }

    public ApplicationGrantedAuthority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplicationGrantedAuthority) {

            return getId().equals(((ApplicationGrantedAuthority) obj).getId())
                    && name.equals(((ApplicationGrantedAuthority) obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (getId() == null ? 0 : getId().hashCode());
        result = 31 * result + name.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("ApplicationGrantedAuthority {id = %d; name = %s}", getId(), name);
    }
}
