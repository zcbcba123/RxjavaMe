package com.love.flower.rxjavame.utils;


import android.net.Uri;

import com.google.gson.Gson;
import com.love.flower.rxjavame.rx.Observable;
import com.love.flower.rxjavame.rx.Observer;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;

public class NetApi {
    public static final String URL = "";
    /**
     * 获取新闻列表
     * @param page      当前页数
     * @param itemCount 条目数量
     * @return          请求后的响应结果
     */
    public Observable<Response> getNewsList(int page, int itemCount){
        return new Observable<Response>() {
            @Override
            public void subscribe(final Observer<Response> observer) {
                OkGo.get(URL)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, okhttp3.Response response) {
                                Response convert = new Gson().fromJson(s, Response.class);
                                observer.onNext(convert);
                            }

                            @Override
                            public void onError(Call call, okhttp3.Response response, Exception e) {
                                super.onError(call, response, e);
                                observer.onError(e);
                            }
                        });
            }
        };
    }

    /**
     * 保存标题到文件
     * @param title 标题
     * @return      返回对应的uri
     */
    public Observable<Uri> save(String title){
        return new Observable<Uri>() {
            @Override
            public void subscribe(final Observer<Uri> observer) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //保存标题然后进行保存成功的回调，把保存好的uri传出去
                            observer.onNext(Uri.parse("xxxxx"));
                        } catch (Exception e) {
                            observer.onError(e);
                        }
                    }
                }
                ).start();
            }
        };
    }
}
