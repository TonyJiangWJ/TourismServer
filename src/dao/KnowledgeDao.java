package dao;

import java.util.ArrayList;

import model.Knowledge;

public interface KnowledgeDao {
	public boolean AddNLG(Knowledge nlg);
	public boolean DeleteNLG(Knowledge nlg);
	public boolean AdjustNLG(Knowledge nlg);
	public ArrayList<Knowledge> listKnowledges();
}
