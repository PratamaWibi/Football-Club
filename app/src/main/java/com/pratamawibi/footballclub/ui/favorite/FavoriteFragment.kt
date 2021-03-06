package com.pratamawibi.footballclub.ui.favorite

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawibi.footballclub.R
import com.pratamawibi.footballclub.ui.adapter.ViewPagerAdapter
import com.pratamawibi.footballclub.ui.favorite.team.FavoriteTeamFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(activity as AppCompatActivity){
            setSupportActionBar(toolbar_favorite)
            setTitle(R.string.football_favorites)
            view_pager_favorite.adapter = ViewPagerAdapter(childFragmentManager, mapOf(
                    getString(R.string.teams) to FavoriteTeamFragment()
            ))
            tab_layout_favorite.setupWithViewPager(view_pager_favorite)
        }
    }
}
