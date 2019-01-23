package com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmconverters

import io.realm.RealmList
import io.realm.RealmObject
import org.parceler.converter.CollectionParcelConverter

abstract class RealmListParcelConverter<T : RealmObject> : CollectionParcelConverter<T, RealmList<T>>() {

    override fun createCollection(): RealmList<T> {
        return RealmList()
    }
}