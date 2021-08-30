package com.example.codechallenge.ui.eventsList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.networkHandler.NetworkHandler
import com.example.codechallenge.repository.EventRepository
import com.example.codechallenge.utils.LoadingState
import com.example.codechallenge.utils.handleLoadingState
import com.example.codechallenge.utils.performCallWhenInternetIsAvailable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class EventsViewModel @Inject constructor(
    eventRepository: EventRepository,
    networkHandler: NetworkHandler
) :
    ViewModel() {

    private val _eventResponse = MutableLiveData<List<BaseEventModel>>()
    val eventResponse: LiveData<List<BaseEventModel>> get() = _eventResponse

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState> get() = _loadingState

    private val compositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(
            eventRepository.getEvents()
                .performCallWhenInternetIsAvailable(networkHandler.observeNetworkState())
                .observeOn(AndroidSchedulers.mainThread())
                .handleLoadingState(_loadingState)
                .subscribe({ eventResponse ->
                    _eventResponse.postValue(eventResponse)
                }, { error ->
                    Log.e("error:", error.toString())
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
