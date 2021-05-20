package ru.itsinfo.securityjwt.service;

import ru.itsinfo.securityjwt.dto.TestEntityDto;

import java.util.List;

public interface TestEntityService {

    List<TestEntityDto> findAll();

    TestEntityDto findById(Long id);
}
