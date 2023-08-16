package mainApp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.model.User;

public interface UserDAO extends JpaRepository<User, String> {
	
	Optional<User> findByUsername(String username);

}
