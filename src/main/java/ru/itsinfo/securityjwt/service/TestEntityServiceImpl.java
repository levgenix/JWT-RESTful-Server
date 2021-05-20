package ru.itsinfo.securityjwt.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itsinfo.securityjwt.dto.TestEntityDto;
import ru.itsinfo.securityjwt.dto.TestEntityMapper;
import ru.itsinfo.securityjwt.repository.TestEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TestEntityServiceImpl implements TestEntityService {

    private final TestEntityRepository testEntityRepository;
    private final TestEntityMapper modelMapper;

    @Autowired
    public TestEntityServiceImpl(TestEntityRepository testEntityRepository, TestEntityMapper modelMapper) {
        this.testEntityRepository = testEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestEntityDto> findAll() {
        return testEntityRepository.findAll().stream()
                .map(modelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestEntityDto findById(Long id) {
        final var findEntity = this.testEntityRepository.findById(id);
        log.info("IN findById - {} find entity", findEntity);
        return findEntity.map(modelMapper::toDto).orElse(null);
    }
}
