package ru.itsinfo.securityjwt.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itsinfo.securityjwt.model.TestEntity;

import java.util.Objects;

@Component
public class TestEntityMapper {

    private final ModelMapper mapper;

    @Autowired
    public TestEntityMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public TestEntityDto toDto(TestEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TestEntityDto.class);
    }

    public TestEntity toEntity(TestEntityDto entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TestEntity.class);
    }
}
