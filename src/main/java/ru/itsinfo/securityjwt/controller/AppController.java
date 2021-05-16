package ru.itsinfo.securityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.itsinfo.securityjwt.dto.TestEntityDto;
import ru.itsinfo.securityjwt.service.AppService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    // TODO: 15.05.2021 implements
    @PostMapping("/user/register")
    public void register() {

    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return new RedirectView("/login");
    }

    @GetMapping("/entities")
    public ResponseEntity<Iterable<TestEntityDto>> findAll() {
        return ResponseEntity.ok(appService.findAll());
    }

    @GetMapping(value = "/entities/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        var entityDto = appService.findById(id);

        if (entityDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(entityDto);
    }
}
