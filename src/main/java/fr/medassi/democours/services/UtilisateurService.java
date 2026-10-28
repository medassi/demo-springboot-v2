package fr.medassi.democours.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.medassi.democours.models.Utilisateur;
import fr.medassi.democours.repositories.UtilisateurRepository;

@Service 
public class UtilisateurService implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<Utilisateur> u = utilisateurRepository.findByMail(mail) ;
        if( u.isPresent()) {
            return u.get();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le mail: " + mail);
        }
    }   

}
