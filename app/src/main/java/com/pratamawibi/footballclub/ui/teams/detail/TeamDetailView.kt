package com.pratamawibi.footballclub.ui.teams.detail

interface TeamDetailView {
    fun onRemoveFromFavorite(result: String?)
    fun onAddToFavorite(result: String?)
}