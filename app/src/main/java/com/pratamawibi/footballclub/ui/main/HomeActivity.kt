package com.pratamawibi.footballclub.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pratamawibi.footballclub.R
import com.pratamawibi.footballclub.R.layout.activity_home
import com.pratamawibi.footballclub.ui.favorite.FavoriteFragment
import com.pratamawibi.footballclub.ui.teams.TeamFragment
import com.pratamawibi.footballclub.util.FragmentTransaction.Companion.pushFragments
import com.pratamawibi.footballclub.util.KeyValue.Companion.TAG_FAVORITE
import com.pratamawibi.footballclub.util.KeyValue.Companion.TAG_TEAM
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        pushFragments(this, TAG_FAVORITE, FavoriteFragment())
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                bottom_navigation.selectedItemId -> return@setOnNavigationItemSelectedListener false
                R.id.teams -> {
                    pushFragments(this, TAG_TEAM, TeamFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favorites -> {
                    pushFragments(this, TAG_FAVORITE, FavoriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

        bottom_navigation.selectedItemId = R.id.favorites
    }
}