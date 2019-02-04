package com.love.flower.rxjavame.rx;

public interface Observer<T>{
    void onNext(T t);

    void onError(Exception e);
}
