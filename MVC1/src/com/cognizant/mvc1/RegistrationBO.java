package com.cognizant.mvc1;

public class RegistrationBO {
	public boolean registerUser(User user) throws RegistrationException,
			ClassNotFoundException {
		boolean flag = true;
		if (user.getAge() < 18 || user.getAge() > 60) {
			flag = false;
		} else {
			UserDAO userDao = new UserDAO();
			flag = userDao.insertUser(user);
		}
		return flag;
	}

}
