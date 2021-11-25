package com.pratamawibi.footballclub.ui.teams.player

import com.google.gson.Gson
import com.pratamawibi.footballclub.api.ApiRepository
import com.pratamawibi.footballclub.api.TheSportDBApi
import com.pratamawibi.footballclub.util.TestContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PlayersPresenterTest {

    private lateinit var presenter: PlayersPresenter

    @Mock
    private
    lateinit var view: PlayersView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = PlayersPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetPlayers() {
        val players: MutableList<Player> = mutableListOf()
        val response = PlayerResponse(players)
        val teamId = "133604"

        GlobalScope.launch {
            Mockito.`when`(gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getPlayers(teamId)),
                    PlayerResponse::class.java
            )).thenReturn(response)

            presenter.getPlayers(teamId)

            Mockito.verify(view).showLoading()
            try {
                Mockito.verify(view).showPlayers(players)
            } catch (e: Exception) {
                Mockito.verify(view).errorLoading(e.localizedMessage)
            }
            Mockito.verify(view).hideLoading()
        }
    }
}