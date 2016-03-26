package com.tonyjiang.tourismserverdemo.utils.httpUtils.basics;

import com.tonyjiang.tourismserverdemo.model.Tel;
import com.tonyjiang.tourismserverdemo.model.User;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public interface TelClient {
    public void AddTel(Tel tel);
    public void DeleteTel(Tel tel);
    public void ListTel(User user);
}
