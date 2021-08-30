package com.example.codechallenge.repository

import com.example.codechallenge.api.EventApi
import com.example.codechallenge.model.BaseEventModel
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val eventApi: EventApi) : EventRepository {
    override fun getEvents(): Flowable<List<BaseEventModel>> =
        eventApi.getEvents()
            .subscribeOn(Schedulers.io())
            .map {
                it.filterNotNull()
            }
            .repeatWhen { completed -> completed.delay(10, TimeUnit.SECONDS) }
}
