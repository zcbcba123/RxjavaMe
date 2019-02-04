package com.love.flower.rxjavame.rx;

public class OnSubscribeFlatMap<T,R> implements Observable.OnSubscribe<R> {
    private  Observable<T> source;
    private  Fun1<T, Observable<R>> fun1;

    public OnSubscribeFlatMap(Observable<T> observable, Fun1<T,Observable<R>>fun1) {
        source = observable;
        this.fun1 = fun1;
    }
    @Override
    public void call(final Observer<R> rObserver) {
        source.subscribe(new Observer<T>() {
            @Override
            public void onNext(T t) {
                Observable<R> call = fun1.call(t);
                call.subscribe(new Observer<R>() {
                    @Override
                    public void onNext(R r) {
                        rObserver.onNext(r);
                    }

                    @Override
                    public void onError(Exception e) {
                        rObserver.onError(e);
                    }
                });
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
