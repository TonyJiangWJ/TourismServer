package com.tonyjiang.tourismserverdemo.utils.httpUtils.impls;

import android.os.Handler;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.tonyjiang.tourismserverdemo.model.Topic;
import com.tonyjiang.tourismserverdemo.utils.httpUtils.basics.TopicClient;
import com.tonyjiang.tourismserverdemo.utils.statics.Global;
import com.tonyjiang.tourismserverdemo.utils.statics.JsonTool;

import cz.msebera.android.httpclient.Header;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public class TopicClientImpl implements TopicClient {
    private Handler mHandler;
    private AsyncHttpClient mClient;
    private final String AddUrl = Global.LocalHost+"AddTopic";
    private final String DeleteUrl = Global.LocalHost+"DeleteTopic";
    private final String AddPeopleUrl = Global.LocalHost+"AddTopicPeople";
    private final String ListUrl = Global.LocalHost+"ListTopic";
    public TopicClientImpl(Handler handler){
        mHandler = handler;
        mClient = new AsyncHttpClient();
        mClient.setTimeout(5000);
        mClient.setConnectTimeout(5000);
    }
    @Override
    public void AddTopic(Topic topic) {
        RequestParams params = new RequestParams();
        params.add("jsonTopic", JsonTool.toJson(topic));
        mClient.post(AddUrl, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.SUCCESS));
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.FAIL));
            }
        });
    }

    @Override
    public void DeleteTopic(Topic topic) {
        RequestParams params = new RequestParams();
        params.add("tpcName",topic.getTpc_name());
        mClient.post(DeleteUrl, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.SUCCESS));
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.FAIL));
            }
        });
    }

    @Override
    public void ListTopic() {
        mClient.get(ListUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.SUCCESS));
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.FAIL));
            }
        });
    }

    @Override
    public void AddPeople(Topic topic) {
        RequestParams params = new RequestParams();
        params.add("jsonTopic",JsonTool.toJson(topic));
        mClient.post(AddPeopleUrl, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.SUCCESS));
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                mHandler.sendMessage(Global.DealFinal(bytes,Global.FAIL));
            }
        });
    }
}
