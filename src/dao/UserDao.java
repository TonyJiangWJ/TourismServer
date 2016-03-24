package dao;

import model.*;

public interface UserDao {
	public boolean SignUp(User usr);
	public boolean Check(User usr);
	public User Login(User usr);
}
