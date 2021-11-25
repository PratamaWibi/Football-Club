package com.pratamawibi.footballclub.ui.favorite.team

import com.pratamawibi.footballclub.model.Team

interface FavoriteTeamView {
    fun showLoading()
    fun hideLoading()
    fun showFavorite(favorites: List<Team>)
    fun errorLoading(e: String?)
}