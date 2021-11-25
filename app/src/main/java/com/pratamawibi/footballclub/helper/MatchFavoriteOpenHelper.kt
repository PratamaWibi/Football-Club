package com.pratamawibi.footballclub.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.pratamawibi.footballclub.model.Team
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context)
    : ManagedSQLiteOpenHelper(ctx, "Favorites.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        //creating db
        db.createTable(Team.TABLE_TEAMS, true,
                Team.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                Team.ID_TEAM to TEXT,
                Team.TEAM_BADGE to TEXT,
                Team.TEAM to TEXT,
                Team.FORMED_YEAR to TEXT,
                Team.STADIUM to TEXT,
                Team.DESCRIPTION to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //upgrade table
        db.dropTable(Team.TABLE_TEAMS, true)
    }
}

//access ctx
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)