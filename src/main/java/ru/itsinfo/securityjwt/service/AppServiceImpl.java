package ru.itsinfo.securityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itsinfo.securityjwt.model.TestDto;
import ru.itsinfo.securityjwt.repository.AppRepository;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;

    @Autowired
    public AppServiceImpl(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public List<TestDto> findAll() {
        return appRepository.findAll();
    }
}
