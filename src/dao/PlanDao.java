package dao;

import java.util.ArrayList;

import model.Plan;

public interface PlanDao {
	public boolean AddPlan(Plan plan);
	public boolean DeletePlan(Plan plan);
	public ArrayList<Plan> ListPlan();
	public boolean AddPeople(Plan plan);
}
