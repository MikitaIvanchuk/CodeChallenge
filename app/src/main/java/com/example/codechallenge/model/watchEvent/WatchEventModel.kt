package com.example.codechallenge.model.watchEvent

import com.example.codechallenge.model.Actor
import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.model.EventTypes
import com.example.codechallenge.model.Repo
import com.google.gson.annotations.SerializedName

data class WatchEventModel(
    override val actor: Actor,
    @SerializedName("created_at")
    override val createdAt: String,
    override val id: String,
    @SerializedName("payload")
    val watchEventPayload: WatchEventPayload,
    @SerializedName("`public`")
    override val isPublic: Boolean,
    override val repo: Repo,
    override val type: EventTypes
) : BaseEventModel
