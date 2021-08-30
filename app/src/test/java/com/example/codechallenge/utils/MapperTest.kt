package com.example.codechallenge.utils

import com.example.codechallenge.model.Actor
import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.model.EventTypes
import com.example.codechallenge.model.Repo
import org.junit.Test

class MapperTest {

    data class TestModel(
        override val actor: Actor,
        override val createdAt: String,
        override val id: String,
        override val isPublic: Boolean,
        override val repo: Repo,
        override val type: EventTypes
    ) : BaseEventModel

    @Test
    fun `test mapper to pull request event model`() {
        val responseModel =
            TestModel(
                actor = Actor(
                    avatarUrl = "avatar_url",
                    displayLogin = "display_login",
                    avatarId = "id",
                    id = 1,
                    login = "login",
                    url = "url"
                ),
                createdAt = "created_at",
                id = "model_id",
                isPublic = false,
                repo = Repo(
                    id = 123,
                    name = "repo_name",
                    url = "repo_url"
                ),
                type = EventTypes.PULL_REQUEST_EVENT
            )
        val detailsModel = Mapper.mapToUIModel(responseModel)
        detailsModel?.let { assert(it.equals(responseModel)) }
    }

    @Test
    fun `test mapper to push event model`() {
        val responseModel =
            TestModel(
                actor = Actor(
                    avatarUrl = "avatar_url",
                    displayLogin = "display_login",
                    avatarId = "id",
                    id = 1,
                    login = "login",
                    url = "url"
                ),
                createdAt = "created_at",
                id = "model_id",
                isPublic = false,
                repo = Repo(
                    id = 123,
                    name = "repo_name",
                    url = "repo_url"
                ),
                type = EventTypes.PUSH_EVENT
            )
        val detailsModel = Mapper.mapToUIModel(responseModel)
        detailsModel?.let { assert(it.equals(responseModel)) }
    }

    @Test
    fun `test mapper to create event model`() {
        val responseModel =
            TestModel(
                actor = Actor(
                    avatarUrl = "avatar_url",
                    displayLogin = "display_login",
                    avatarId = "id",
                    id = 1,
                    login = "login",
                    url = "url"
                ),
                createdAt = "created_at",
                id = "model_id",
                isPublic = false,
                repo = Repo(
                    id = 123,
                    name = "repo_name",
                    url = "repo_url"
                ),
                type = EventTypes.CREATE_EVENT
            )
        val detailsModel = Mapper.mapToUIModel(responseModel)
        detailsModel?.let { assert(it.equals(responseModel)) }
    }

    @Test
    fun `test mapper to watch event model`() {
        val responseModel =
            TestModel(
                actor = Actor(
                    avatarUrl = "avatar_url",
                    displayLogin = "display_login",
                    avatarId = "id",
                    id = 1,
                    login = "login",
                    url = "url"
                ),
                createdAt = "created_at",
                id = "model_id",
                isPublic = false,
                repo = Repo(
                    id = 123,
                    name = "repo_name",
                    url = "repo_url"
                ),
                type = EventTypes.PULL_REQUEST_EVENT
            )
        val detailsModel = Mapper.mapToUIModel(responseModel)
        detailsModel?.let { assert(it.equals(responseModel)) }
    }

    @Test
    fun `test mapper to issue event model`() {
        val responseModel =
            TestModel(
                actor = Actor(
                    avatarUrl = "avatar_url",
                    displayLogin = "display_login",
                    avatarId = "id",
                    id = 1,
                    login = "login",
                    url = "url"
                ),
                createdAt = "created_at",
                id = "model_id",
                isPublic = false,
                repo = Repo(
                    id = 123,
                    name = "repo_name",
                    url = "repo_url"
                ),
                type = EventTypes.PULL_REQUEST_EVENT
            )
        val detailsModel = Mapper.mapToUIModel(responseModel)
        detailsModel?.let { assert(it.equals(responseModel)) }
    }
}
