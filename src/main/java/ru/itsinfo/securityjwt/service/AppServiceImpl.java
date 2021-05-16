package ru.itsinfo.securityjwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itsinfo.securityjwt.dto.TestEntityDto;
import ru.itsinfo.securityjwt.dto.TestEntityMapper;
import ru.itsinfo.securityjwt.repository.AppRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AppServiceImpl implements AppService {

    private final AppRepository appRepository;
    private final TestEntityMapper modelMapper;

    @Autowired
    public AppServiceImpl(AppRepository appRepository, TestEntityMapper modelMapper) {
        this.appRepository = appRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestEntityDto> findAll() {
        return appRepository.findAll().stream()
                .map(modelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestEntityDto findById(Long id) {
        final var findEntity = this.appRepository.findById(id);
        log.info("IN findById - {} find entity", findEntity);
        return findEntity.map(modelMapper::toDto).orElse(null);
    }
}
