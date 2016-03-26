package com.tonyjiang.tourismserverdemo.utils.httpUtils.basics;

import com.tonyjiang.tourismserverdemo.model.Plan;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public interface PlanClient {
    public void AddPlan(Plan plan);
    public void AddPlanPeople(Plan plan);
    public void AdjustPlan(Plan plan);
    public void DeletePlan(Plan plan);
    public void ListPlan();
}
