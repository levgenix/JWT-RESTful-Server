package ru.itsinfo.securityjwt.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated", insertable = false)
    private LocalDateTime updated;

    @PrePersist
    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate() {
        setUpdated(LocalDateTime.now());
    }
}
