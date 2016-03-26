package com.tonyjiang.tourismserverdemo.utils.httpUtils.basics;

import com.tonyjiang.tourismserverdemo.model.Topic;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public interface TopicClient {
    public void AddTopic(Topic topic);
    public void DeleteTopic(Topic topic);
    public void ListTopic();
    public void AddPeople(Topic topic);
}
