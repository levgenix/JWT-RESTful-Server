package ru.itsinfo.securityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itsinfo.securityjwt.dto.TestEntityDto;
import ru.itsinfo.securityjwt.service.TestEntityService;

@RestController
@RequestMapping("/api/entities")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class TestEntityRestController {

    private final TestEntityService testEntityService;

    @Autowired
    public TestEntityRestController(TestEntityService testEntityService) {
        this.testEntityService = testEntityService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<TestEntityDto>> findAll() {
        return ResponseEntity.ok(testEntityService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        var entityDto = testEntityService.findById(id);

        if (entityDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(entityDto);
    }
}
