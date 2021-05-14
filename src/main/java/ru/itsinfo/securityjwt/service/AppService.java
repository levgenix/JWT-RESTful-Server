package ru.itsinfo.securityjwt.service;

import ru.itsinfo.securityjwt.model.TestDto;

import java.util.List;

public interface AppService {

    List<TestDto> findAll();
}
