package com.love.flower.rxjavame;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.love.flower.rxjavame.rx.Observable;
import com.love.flower.rxjavame.rx.Fun1;
import com.love.flower.rxjavame.rx.Observer;
import com.love.flower.rxjavame.utils.ApiHelper;
import com.love.flower.rxjavame.utils.NetApi;
import com.love.flower.rxjavame.utils.Response;

public class MainActivity extends AppCompatActivity {

    private ApiHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        helper = new ApiHelper();
        test();
    }

    private NetApi netApi = new NetApi();

    public void test() {
        netApi.getNewsList(1, 20)
                .map(new Fun1<Response, String>() {
                    @Override
                    public String call(Response response) {
                        return findLatestTitle(response);
                    }
                })
                .flatMap(new Fun1<String, Observable<Uri>>() {
                    @Override
                    public Observable<Uri> call(String s) {
                        return netApi.save(s);
                    }
                })
                .subscribe(new Observer<Uri>() {
                    @Override
                    public void onNext(Uri uri) {
                        System.out.println(uri);
                    }

                    @Override
                    public void onError(Exception e) {
                        System.out.println(e);
                    }
                });
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

        save.subscribe(new Observer<Uri>() {
            @Override
            public void onNext(Uri uri) {
                System.out.println(uri);
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e);
            }
        });*/
        /*Observable<Uri> andSaveLatestTitle = helper.getAndSaveLatestTitle();
        andSaveLatestTitle.subscribe(new Observer<Uri>() {
            @Override
            public void onNext(Uri uri) {
                System.out.println(uri);
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e);
            }
        });*/

       /* helper.getAndSaveLatestTitle(new Observer<Uri>() {
            @Override
            public void onNext(Uri uri) {
                System.out.println(uri);
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e);
            }
        });*/
    }

    /**
     * 找到最近的title
     *
     * @param response
     * @return
     */
    private String findLatestTitle(Response response) {
        return response.toString();
    }
}
