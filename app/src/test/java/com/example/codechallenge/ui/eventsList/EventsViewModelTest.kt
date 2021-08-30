package com.example.codechallenge.ui.eventsList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.codechallenge.RxImmediateSchedulerRule
import com.example.codechallenge.model.Actor
import com.example.codechallenge.model.BaseEventModel
import com.example.codechallenge.model.EventTypes
import com.example.codechallenge.model.Repo
import com.example.codechallenge.networkHandler.NetworkHandler
import com.example.codechallenge.repository.EventRepository
import com.example.codechallenge.utils.LoadingState
import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class EventsViewModelTest {

    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Mock
    lateinit var repositoryImpl: EventRepository

    @Mock
    lateinit var eventModelObserver: Observer<List<BaseEventModel>>

    @Mock
    lateinit var loadingStateObserver: Observer<LoadingState>

    @Mock
    lateinit var networkHandler: NetworkHandler

    lateinit var evensViewModel: EventsViewModel

    data class TestModel(
        override val actor: Actor,
        override val createdAt: String,
        override val id: String,
        override val isPublic: Boolean,
        override val repo: Repo,
        override val type: EventTypes
    ) : BaseEventModel

    private val testItem = TestModel(
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

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test liveData for expected data and loading state for success`() {
        val testList = listOf(testItem)
        `when`(repositoryImpl.getEvents()).thenReturn(Flowable.just(testList))
        `when`(networkHandler.observeNetworkState()).thenReturn(Observable.just(true))
        evensViewModel = EventsViewModel(repositoryImpl, networkHandler)

        evensViewModel.eventResponse.observeForever(eventModelObserver)
        evensViewModel.loadingState.observeForever(loadingStateObserver)

        assert(evensViewModel.eventResponse.value == testList)
        assert(evensViewModel.loadingState.value == LoadingState.Success)
    }

    @Test
    fun `test call and loading state states without internet`() {
        val testList = listOf(testItem)
        `when`(repositoryImpl.getEvents()).thenReturn(Flowable.just(testList))
        `when`(networkHandler.observeNetworkState()).thenReturn(Observable.just(false))

        evensViewModel = EventsViewModel(repositoryImpl, networkHandler)
        evensViewModel.eventResponse.observeForever(eventModelObserver)
        evensViewModel.loadingState.observeForever(loadingStateObserver)

        assert(evensViewModel.loadingState.value is LoadingState.Error)
        assert(evensViewModel.eventResponse.value == null)
    }

    @Test
    fun `test to check if repository is called only once`() {
        val testList = listOf(testItem)
        `when`(repositoryImpl.getEvents()).thenReturn(Flowable.just(testList))
        `when`(networkHandler.observeNetworkState()).thenReturn(Observable.just(true))
        evensViewModel = EventsViewModel(repositoryImpl, networkHandler)

        verify(repositoryImpl, times(1)).getEvents()
    }
}
