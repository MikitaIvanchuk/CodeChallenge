package com.example.codechallenge.utils

import io.reactivex.Flowable
import io.reactivex.Observable
import java.net.ConnectException
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

fun <T> Flowable<T>.performCallWhenInternetIsAvailable(networkStateObservable: Observable<Boolean>): Flowable<T> =
    networkStateObservable
        .filter { it }
        .firstOrError()
        .flatMapPublisher { this }
        .retryWhen { errors ->
            errors.flatMap { error ->
                if (error !is ConnectException && error !is UnknownHostException) {
                    throw error
                } else {
                    Flowable.timer(5, TimeUnit.SECONDS)
                }
            }
        }
