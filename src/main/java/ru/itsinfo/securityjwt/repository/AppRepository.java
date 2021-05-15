package ru.itsinfo.securityjwt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itsinfo.securityjwt.model.TestDto;

import java.util.List;

// TODO: 15.05.2021 using spring-boot-starter-data-rest
@RepositoryRestResource(collectionResourceRel = "testdto", path = "testdto")
public interface AppRepository extends PagingAndSortingRepository<TestDto, Long> {
//public interface AppRepository extends JpaRepository<TestDto, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page<TestDto> findByEmailStartsWith(@Param("email") String email, Pageable p);
}