package com.love.flower.rxjavame.rx;

public class OnSubscribeMap<T,R> implements Observable.OnSubscribe<R>{
    private  Observable<T> source;
    private  Fun1<T, R> fun1;

    public OnSubscribeMap(Observable<T> observable, Fun1<T,R>fun1) {
        source = observable;
        this.fun1 = fun1;
    }


    @Override
    public void call(final Observer<R> rObserver) {
        source.subscribe(new Observer<T>() {
            @Override
            public void onNext(T t) {
                R r = fun1.call(t);
                rObserver.onNext(r);
            }

            @Override
            public void onError(Exception e) {
                rObserver.onError(e);
            }
        });
    }
}
