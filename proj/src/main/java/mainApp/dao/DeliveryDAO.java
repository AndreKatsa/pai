package mainApp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.model.Delivery;
import mainApp.model.Species;

public interface DeliveryDAO extends JpaRepository<Delivery, Integer> {
	
	Optional<Species> findById(int id);
}
