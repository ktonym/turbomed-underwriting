package ke.co.turbosoft.med.service;

import java.util.List;

import ke.co.turbosoft.med.entity.User;

public interface UserService {
	
	public List<User> findAll();
	public User findOne(Integer userId);
	public void save(User user);
	
}
