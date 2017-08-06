package springmvc_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_crud.dao.UserDao;
import springmvc_crud.model.User;

@Service
public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> listAllUser() {
		return userDao.listAllUser();
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

}
