package mainApp.service;

import org.springframework.stereotype.Service;

import mainApp.model.User;

@Service
public interface UserService {
	public void saveUser(User user);
    public boolean isUserPresent(User user);
}
