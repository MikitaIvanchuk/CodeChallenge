package com.example.codechallenge.utils

import androidx.lifecycle.MutableLiveData
import io.reactivex.Flowable

sealed class LoadingState {
    object Load : LoadingState()
    object Success : LoadingState()
    class Error(val throwable: Throwable) : LoadingState()
}

fun <T> Flowable<T>.handleLoadingState(liveData: MutableLiveData<LoadingState>): Flowable<T> =
    this.doOnSubscribe { liveData.postValue(LoadingState.Load) }
        .doOnNext { liveData.postValue(LoadingState.Success) }
        .doOnError { liveData.postValue(LoadingState.Error(it)) }
