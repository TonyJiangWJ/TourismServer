package dao;

import java.util.ArrayList;

import model.Topic;

public interface TopicDao {
	public boolean AddTopic(Topic tpc);
	public boolean DeleteTopic(Topic tpc);
	public ArrayList<Topic> ListTopic();
	public boolean AddPeople(Topic tpc);
}
