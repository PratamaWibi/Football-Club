package com.pratamawibi.footballclub.ui.teams

import com.pratamawibi.footballclub.model.LeagueResponse
import com.pratamawibi.footballclub.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showLeagues(data: LeagueResponse)
    fun showTeams(data: List<Team>)
    fun errorLoading(e: String?)
}