package dao;

import java.util.ArrayList;

import model.Activities;

public interface ActivityDao {
	public boolean AddActivity(Activities act);
	public boolean DeleteActivity(Activities act);
	public boolean DeleteActivity(String act_id);
	public boolean AdjusetActivity(Activities act);
	public ArrayList<Activities> ListActivities();
}
