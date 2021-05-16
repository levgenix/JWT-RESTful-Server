package ru.itsinfo.securityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsinfo.securityjwt.model.TestEntity;

// TODO: 15.05.2021 using spring-boot-starter-data-rest
//@RepositoryRestResource(collectionResourceRel = "testdto", path = "testdto")
public interface AppRepository extends JpaRepository<TestEntity, Long> {
}