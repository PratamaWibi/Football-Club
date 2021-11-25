package com.pratamawibi.footballclub.ui.teams.search

import android.view.Menu
import android.view.MenuInflater
import com.pratamawibi.footballclub.model.Team

interface TeamSearchView {
    fun showLoading()
    fun hideLoading()
    fun showSearchResult(data: List<Team>)
    fun errorLoading(e: String?)
    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?)
}