package dao;

import java.util.ArrayList;

import model.Tel;

public interface TelDao {
	public boolean AddFriend(Tel tel);
	public boolean DeleteFriend(Tel tel);
	public ArrayList<Tel> ListFriend(Tel tel);
}
