package fr.medassi.democours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.medassi.democours.models.Equipement;


public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    
}
