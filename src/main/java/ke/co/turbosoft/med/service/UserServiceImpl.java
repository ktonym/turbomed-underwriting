package ke.co.turbosoft.med.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(Integer userId) {
		return userRepo.findOne(userId);
	}

	@Override
	@Transactional
	public void save(User user) {
		userRepo.save(user);
	}

}
