package com.pratamawibi.footballclub.api

import android.net.Uri
import com.pratamawibi.footballclub.BuildConfig

object TheSportDBApi {

    fun getLeague(): String {
        return "${BuildConfig.BASE_URL}/api/v1/json/2/all_leagues.php"
    }

    fun getTeamDetail(id: String?): String {
        return "${BuildConfig.BASE_URL}/api/v1/json/2/lookupteam.php?id=$id"
    }

    fun getTeams(league: String?): String {
        return try {
            Uri.parse(BuildConfig.BASE_URL).buildUpon()
                    .appendPath("api")
                    .appendPath("v1")
                    .appendPath("json")
                    .appendPath("2")
                    .appendPath("search_all_teams.php")
                    .appendQueryParameter("l", league)
                    .build()
                    .toString()
        } catch (e: Exception) {
            "${BuildConfig.BASE_URL}/api/v1/json/2/search_all_teams.php?l=$league"
        }
    }

    fun getTeamSearch(keyword: String?): String {
        return "${BuildConfig.BASE_URL}/api/v1/json/2/searchteams.php?t=$keyword"

    }

}