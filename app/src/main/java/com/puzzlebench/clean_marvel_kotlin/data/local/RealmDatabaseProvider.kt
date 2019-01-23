package com.puzzlebench.clean_marvel_kotlin.data.local

import io.realm.Realm
import io.realm.RealmModel

class RealmDatabaseProvider<T : RealmModel> : RealmWrapper<T> {

    override fun queryAll(clazz: Class<T>): List<T> {

        Realm.getDefaultInstance().use { realmInstance ->
            return realmInstance.copyFromRealm(realmInstance.where(clazz).findAll())
        }
    }

    override fun save(obj: T) {

        Realm.getDefaultInstance().use { realmInstance ->
            realmInstance.executeTransaction { realm -> realm.copyToRealm(obj) }
        }
    }

    override fun deleteAll(clazz: Class<T>) {

        Realm.getDefaultInstance().use { realmInstance ->
            realmInstance.executeTransaction { realm -> realm.deleteAll() }
        }
    }
}