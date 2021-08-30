package com.example.codechallenge.repository

import com.example.codechallenge.model.BaseEventModel
import io.reactivex.Flowable

interface EventRepository {
    fun getEvents(): Flowable<List<BaseEventModel>>
}
