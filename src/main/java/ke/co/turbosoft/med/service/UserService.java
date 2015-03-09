package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.User;
import ke.co.turbosoft.med.vo.Result;

import java.util.List;

public interface UserService {
	
	public Result<List<User>> findAll(String actionUsername);
	public Result<User> findByUsernameAndPassword(String username,String password);
	public Result<User> store(
        String username,
        String email,
        String password,
        String firstName,
        String lastName,
        String actionUsername);
    public Result<User> remove(String username, String actionUsername);

    Result<User> find(String username, String actionUsername);
}
