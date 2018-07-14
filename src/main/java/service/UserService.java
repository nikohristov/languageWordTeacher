package service;

import exception.DataNotFoundException;
import exception.InvalidInputException;
import model.User;
import repository.UserRepository;

public class UserService {
	
	private UserRepository userRepo;
	
	public UserService() {
		this.userRepo = new UserRepository();
	}
	
	public User logInUser(String username, String password) throws InvalidInputException {
		boolean invalidInput = false;
		User user = null;
		try {
			user = this.userRepo.fetchUserByUsername(username);
			if (!user.getPassword().equals(password)) {
				invalidInput = true;
			}
			
		} catch (DataNotFoundException e) {
			invalidInput = true;
		}
		
		if (invalidInput) {
			throw new InvalidInputException();
		}
		
		return user;
	}
	
}
