package fr.medassi.democours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.medassi.democours.models.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    java.util.Optional<Utilisateur> findByMail(String mail);
}
