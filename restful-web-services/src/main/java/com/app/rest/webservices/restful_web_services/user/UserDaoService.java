package com.app.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int count = 0;
	
	static {
		users.add(new User(++count, "Jack", LocalDate.now().minusYears(20)));
		users.add(new User(++count, "Jen", LocalDate.now().minusYears(23)));
		users.add(new User(++count, "Jolly", LocalDate.now().minusYears(27)));
	}
	
	public List<User> findAllUsers() {
		return users;
	}
	
	public User findUser(int id) {
		
		Predicate<User> predicate = user -> user.getId()== id;
		User user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}
	
	public User save(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		
		Predicate<User> predicate = user -> user.getId()== id;
		User user = users.stream().filter(predicate).findFirst().orElse(null);
		users.remove(user.getId());
	}
}
