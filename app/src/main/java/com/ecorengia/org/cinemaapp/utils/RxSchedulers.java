package com.ecorengia.org.cinemaapp.utils;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Rx scheduler combinations.
 *
 * @author ecorengia
 */
public final class RxSchedulers {

    private RxSchedulers() {
        // Utility class don't instantiate
    }

    public static <T> SingleTransformer<T, T> applySingleAsync() {
        return single -> single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> SingleTransformer<T, T> applySingleCompute() {
        return single -> single.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> SingleTransformer<T, T> applySingleMainThread() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> applyObservableAsync() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> applyObservableCompute() {
        return observable -> observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> applyObservableMainThread() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<T, T> applyFlowableMainThread() {
        return flowable -> flowable.observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<T, T> applyFlowableAsysnc() {
        return flowable -> flowable.observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<T, T> applyFlowableCompute() {
        return flowable -> flowable.observeOn(AndroidSchedulers.mainThread());
    }
}
