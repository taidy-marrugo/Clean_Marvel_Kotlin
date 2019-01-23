package com.puzzlebench.clean_marvel_kotlin

import android.app.Application
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmmodule.MarvelRealmModule
import io.realm.Realm
import io.realm.RealmConfiguration

class MarvelApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .modules(MarvelRealmModule())
                .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }
}