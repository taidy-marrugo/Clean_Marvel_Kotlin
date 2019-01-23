package com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmconverters

import android.os.Parcel
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.CharacterUrl
import org.parceler.Parcels

class CharacterUrlRealmListConverter : RealmListParcelConverter<CharacterUrl>() {

    override fun itemFromParcel(parcel: Parcel?): CharacterUrl {
        return Parcels.unwrap(parcel?.readParcelable(CharacterUrl::class.java.classLoader))
    }

    override fun itemToParcel(input: CharacterUrl?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }
}