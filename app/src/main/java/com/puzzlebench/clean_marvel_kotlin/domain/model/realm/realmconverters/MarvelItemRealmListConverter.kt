package com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmconverters

import android.os.Parcel
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.MarvelItem
import org.parceler.Parcels

class MarvelItemRealmListConverter : RealmListParcelConverter<MarvelItem>(){

    override fun itemFromParcel(parcel: Parcel?): MarvelItem {
        return Parcels.unwrap(parcel?.readParcelable(MarvelItem::class.java.classLoader))
    }

    override fun itemToParcel(input: MarvelItem?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }
}