package com.example.codechallenge.model

import com.google.gson.annotations.SerializedName

enum class EventTypes(val value: String) {
    @SerializedName("PushEvent")
    PUSH_EVENT("PushEvent"),

    @SerializedName("PullRequestEvent")
    PULL_REQUEST_EVENT("PullRequestEvent"),

    @SerializedName("CreateEvent")
    CREATE_EVENT("CreateEvent"),

    @SerializedName("WatchEvent")
    WATCH_EVENT("WatchEvent"),

    @SerializedName("IssueEvent")
    ISSUE_EVENT("IssueEvent");

    companion object {
        fun getFromValue(value: String): EventTypes? =
            values().find { it.value == value }
    }
}
