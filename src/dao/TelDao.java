package dao;

import java.util.ArrayList;

import model.Tel;
import model.User;

public interface TelDao {
	public boolean AddFriend(Tel tel);
	public boolean DeleteFriend(Tel tel);

	public ArrayList<User> ListAll(Tel tel);
}
