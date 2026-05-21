package cm.camtech.crm.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    // Gestion globale des exceptions de l'API avec des messages en français.
    public ResponseEntity<Map<String, String>> handleApiException(ApiException ex) {
        Map<String, String> erreur = new HashMap<>();
        erreur.put("message", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(erreur);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleAuthenticationException(AuthenticationException ex) {
        Map<String, String> erreur = new HashMap<>();
        erreur.put("message", "Échec de l'authentification. Vérifiez vos identifiants.");
        return ResponseEntity.status(401).body(erreur);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> erreur = new HashMap<>();
        erreur.put("message", "Une erreur est survenue, veuillez réessayer plus tard.");
        return ResponseEntity.status(500).body(erreur);
    }
}
