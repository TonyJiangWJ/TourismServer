package com.tonyjiang.tourismserverdemo.utils.httpUtils.basics;

import android.os.Handler;

import com.loopj.android.http.RequestParams;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public interface UserClient {
    public void Login(RequestParams params);
    public void SignUp(RequestParams params);
    public void AdminLogin(RequestParams params);
}
