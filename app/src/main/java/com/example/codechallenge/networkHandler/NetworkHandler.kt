package com.example.codechallenge.networkHandler

import io.reactivex.Observable

interface NetworkHandler {
    fun observeNetworkState(): Observable<Boolean>
}
