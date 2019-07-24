package com.example.announcements.extensions

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.observeOnIO(): Observable<T> = observeOn(Schedulers.io())

fun <T> Single<T>.observeOnIO(): Single<T> = observeOn(Schedulers.io())

fun Completable.observeOnIO(): Completable = observeOn(Schedulers.io())

fun <T> Observable<T>.observeOnMain(): Observable<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.observeOnMain(): Flowable<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.observeOnMain(): Single<T> = observeOn(AndroidSchedulers.mainThread())

fun Completable.observeOnMain(): Completable = observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeOnIO(): Observable<T> = subscribeOn(Schedulers.io())

fun <T> Flowable<T>.subscribeOnIO(): Flowable<T> = subscribeOn(Schedulers.io())

fun <T> Single<T>.subscribeOnIO(): Single<T> = subscribeOn(Schedulers.io())

fun Completable.subscribeOnIO(): Completable = subscribeOn(Schedulers.io())

fun <T> Observable<T>.subscribeOnMain(): Observable<T> = subscribeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeOnMain(): Single<T> = subscribeOn(AndroidSchedulers.mainThread())

fun Completable.subscribeOnMain(): Completable = subscribeOn(AndroidSchedulers.mainThread())