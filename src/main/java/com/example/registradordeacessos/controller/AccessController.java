package com.example.registradordeacessos.controller;

import com.example.registradordeacessos.Access;
import com.example.registradordeacessos.repository.AccessRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccessController {

    AccessRepository accessRepository;
    @GetMapping("/access")
    public Long getAllAccess(HttpServletRequest request) {
        Access access = new Access();
        String userAgent = request.getHeader("User-Agent");
        access.setNavegador(userAgent);
        access.setIp(request.getRemoteAddr());
        access.setDate(LocalDateTime.now());
        accessRepository.save(access);
        return accessRepository.count();
    }
}
