package fr.medassi.democours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.medassi.democours.models.Service;




public interface ServiceRepository extends JpaRepository<Service, Long> {

}
