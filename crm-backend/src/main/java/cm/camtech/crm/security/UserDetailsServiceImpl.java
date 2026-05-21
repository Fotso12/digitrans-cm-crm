package cm.camtech.crm.security;

import cm.camtech.crm.entities.Utilisateurs;
import cm.camtech.crm.repositories.UtilisateursRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UtilisateursRepo utilisateursRepo;

    public UserDetailsServiceImpl(UtilisateursRepo utilisateursRepo) {
        this.utilisateursRepo = utilisateursRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateurs utilisateur = utilisateursRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (utilisateur.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority(utilisateur.getRole()));
        }

        return new User(utilisateur.getEmail(), utilisateur.getMotDePasse(), utilisateur.getActif(), true, true, true, authorities);
    }
}
