package ru.itsinfo.securityjwt.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="users")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class ApplicationUser extends AbstractEntity implements UserDetails {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<ApplicationGrantedAuthority> roles;

    @Column(name = "isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name = "isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name = "enabled")
    private boolean isEnabled;

    public ApplicationUser(String firstName, String lastName, String email, String password,
                           Set<ApplicationGrantedAuthority> roles,
                           boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplicationUser) {

            return getId().equals(((ApplicationUser) obj).getId())
                    && firstName.equals(((ApplicationUser) obj).getFirstName())
                    && lastName.equals(((ApplicationUser) obj).getLastName())
                    && email.equals(((ApplicationUser) obj).getEmail());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + (getId() == null ? 0 : getId().hashCode());
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "ApplicationUser {id = %d; firstName = %s; lastName = %s; email = %s; password = %s; roles = %s, enabled = %b}",
                getId(), firstName, lastName, email, password, roles, isEnabled);
    }
}
