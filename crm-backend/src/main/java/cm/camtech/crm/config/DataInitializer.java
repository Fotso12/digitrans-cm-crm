package cm.camtech.crm.config;

import cm.camtech.crm.entities.Utilisateurs;
import cm.camtech.crm.repositories.UtilisateursRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UtilisateursRepo utilisateursRepo;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UtilisateursRepo utilisateursRepo, PasswordEncoder passwordEncoder) {
        this.utilisateursRepo = utilisateursRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminEmail = "admin@digitrans.cm";
        if (utilisateursRepo.findByEmail(adminEmail).isEmpty()) {
            Utilisateurs admin = new Utilisateurs();
            admin.setNom("Admin");
            admin.setPrenom("Digitrans");
            admin.setEmail(adminEmail);
            admin.setMotDePasse(passwordEncoder.encode("12345678"));
            admin.setRole("ROLE_ADMIN");
            admin.setActif(true);
            admin.setDateCreation(new Date());
            utilisateursRepo.save(admin);
            System.out.println("Utilisateur Admin créé avec succès : " + adminEmail);
        }
    }
}
