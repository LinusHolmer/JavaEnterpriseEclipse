package com.example.lektion6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class DebugRestController {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DebugRestController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<String> testBcryptEncoding(
            @RequestParam(value = "message") String message
    ) {
        String obfuscatedMessage = passwordEncoder.encode(message);

        return ResponseEntity.ok().body(
                "Message was:" + message + " and was hased into " + obfuscatedMessage
        );
    }

    @GetMapping("rest/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdmin() {
        return "It works for ADMIN!";
    }

}
