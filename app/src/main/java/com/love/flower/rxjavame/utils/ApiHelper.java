package com.love.flower.rxjavame.utils;

import android.net.Uri;

import com.love.flower.rxjavame.rx.Observable;


public class ApiHelper {
    private NetApi netApi;
    public ApiHelper(){
        netApi = new NetApi();
    }


    /**
     * 获取并保存最近的title
     * @return
     */
    public Observable<Uri> getAndSaveLatestTitle() {
        /*final Observable<Response> newsList = netApi.getNewsList(1, 20);
        Observable<String> title = newsList.map(new Fun1<Response, String>() {
            @Override
            public String call(Response response) {
                return findLatestTitle(response);
            }
        });

        Observable<Uri> save = title.flatMap(new Fun1<String, Observable<Uri>>() {
            @Override
            public Observable<Uri> call(String s) {
                return netApi.save(s);
            }
        });

        return save;*/

        /*Observable<Uri> save = new Observable<Uri>() {
            @Override
            public void subscribe(final Observer<Uri> callback) {
                title.subscribe(new Observer<String>() {
                    @Override
                    public void onNext(String s) {
                        Observable<Uri> saved = netApi.save(s);
                        saved.subscribe(new Observer<Uri>() {
                            @Override
                            public void onNext(Uri uri) {
                                //已保存
                                callback.onNext(uri);
                            }

                            @Override
                            public void onError(Exception e) {
                                callback.onError(e);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };*/



        /*netApi.getNewsList(1, 20, new Observer<Response>() {
            @Override
            public void onNext(Response response) {
                String title = findLatestTitle(response);
                netApi.save(title, new Observer<Uri>() {
                    @Override
                    public void onNext(Uri uri) {
                        callback.onNext(uri);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                callback.onError(e);
            }
        });*/
        return null;
    }
    /**
     * 找到最近的title
     * @param response
     * @return
     */
//    private String findLatestTitle(Response response){
//        return response.toString();
//    }

}
