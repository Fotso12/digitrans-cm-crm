package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.AuthDto;
import cm.camtech.crm.dtos.RegisterDto;
import cm.camtech.crm.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto authDto) {
        // Point d'entrée de connexion : renvoie un token JWT lorsque les identifiants sont valides.
        String token = authService.authenticate(authDto);
        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        // Point d'entrée d'inscription : crée un compte utilisateur et renvoie un token JWT.
        String token = authService.register(registerDto);
        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);
        return ResponseEntity.ok(resp);
    }
}
