package com.pratamawibi.footballclub.ui.teams

import com.google.gson.Gson
import com.pratamawibi.footballclub.api.ApiRepository
import com.pratamawibi.footballclub.api.TheSportDBApi
import com.pratamawibi.footballclub.model.Team
import com.pratamawibi.footballclub.model.TeamResponse
import com.pratamawibi.footballclub.util.TestContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TeamPresenterTest {

    private lateinit var presenter: TeamPresenter

    @Mock
    private
    lateinit var view: TeamView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TeamPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeams() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val leagueId = "4328"

        GlobalScope.launch {
            Mockito.`when`(gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(leagueId)),
                    TeamResponse::class.java
            )).thenReturn(response)

            presenter.getTeams(leagueId)

            Mockito.verify(view).showLoading()
            try {
                Mockito.verify(view).showTeams(teams)
            } catch (e: Exception) {
                Mockito.verify(view).errorLoading(e.localizedMessage)
            }
            Mockito.verify(view).hideLoading()
        }
    }
}