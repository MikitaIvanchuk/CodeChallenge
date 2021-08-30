package com.example.codechallenge.model.pushEvent

import com.google.gson.annotations.SerializedName

data class PushEventPayload(
    val before: String,
    @SerializedName("distinct_size")
    val distinctSize: Int,
    val head: String,
    @SerializedName("push_id")
    val pushId: Long,
    val ref: String,
    val size: Int
)
