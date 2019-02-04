package com.love.flower.rxjavame.rx;

public class Observable<T> {
    /**
     * 这个接口的目的是什么？就是为了用户调用start方法并传入对应的带不同泛型类的callback
     * 得到对应的结果。
     *
     */
//    public abstract void subscribe(Observer<T> observer);

    public interface OnSubscribe<T> extends Action1<Observer<T>> {

    }

    private OnSubscribe<T> onSubscribe;

    public Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public void subscribe(Observer<T> observer) {
        onSubscribe.call(observer);
    }

    private static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<>(onSubscribe);
    }

    public <R> Observable<R> map(final Fun1<T, R> fun1) {
        return create(new OnSubscribeMap<>(this,fun1));
    }


    public <R> Observable<R> flatMap(final Fun1<T, Observable<R>> fun1) {
        return create(new OnSubscribeFlatMap<>(this,fun1));
    }
}
