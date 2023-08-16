package mainApp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.model.Species;

public interface SpeciesDAO extends JpaRepository<Species, String> {
	
	Optional<Species> findByName(String name);

}