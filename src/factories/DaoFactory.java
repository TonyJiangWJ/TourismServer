package factories;

import dao.*;
import dao.impl.*;

public class DaoFactory {
	public static AdminDao getAdminDao(){
		return new AdminDaoImpl();
	}
	public static CommentDao getCommentDao(){
		return new CommentDaoImpl();
	}
	public static KnowledgeDao getKnowledgeDao(){
		return new KnowledgeDaoImpl();
	}
	public static PlanDao getPlanDao(){
		return new PlanDaoImpl();
	}
	public static TelDao getTelDao(){
		return new TelDaoImpl();
	}
	public static TopicDao getTopicDao(){
		return new TopicDaoImpl();
	}
	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
	
}
