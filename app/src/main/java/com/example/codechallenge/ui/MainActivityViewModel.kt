package com.example.codechallenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codechallenge.networkHandler.NetworkHandler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    networkHandler: NetworkHandler
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val isInternetAvailable = MutableLiveData<Boolean>()

    init {
        compositeDisposable.add(
            networkHandler.observeNetworkState()
                .subscribe {
                    isInternetAvailable.postValue(it)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
