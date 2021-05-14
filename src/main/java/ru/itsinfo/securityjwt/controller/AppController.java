package ru.itsinfo.securityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import ru.itsinfo.securityjwt.model.TestDto;
import ru.itsinfo.securityjwt.service.AppService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        //request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        //RedirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT) // new...

        System.out.println("LOGOUT");
        return new RedirectView("/login");
    }

    @GetMapping("/testdto")
    public ResponseEntity<List<TestDto>> findAll() {
        return ResponseEntity.ok(appService.findAll());
    }
}
