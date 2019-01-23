package com.puzzlebench.clean_marvel_kotlin.domain.model.realm.parcelconverters

import android.os.Parcel
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.MarvelCharacter
import org.parceler.ParcelConverter
import org.parceler.Parcels

class MarvelCharacterListConverter : ParcelConverter<List<MarvelCharacter>> {

    override fun fromParcel(parcel: Parcel?): List<MarvelCharacter> {

        val size = parcel?.readInt()
        if (size!! < 0) return emptyList()
        val items = ArrayList<MarvelCharacter>()

        for (i in 0 until size)
            items.add(Parcels.unwrap(parcel.readParcelable(MarvelCharacter::class.java.classLoader)) as MarvelCharacter)

        return items
    }

    override fun toParcel(input: List<MarvelCharacter>?, parcel: Parcel?) {

        if (input == null) {
            parcel?.writeInt(-1)
        } else {
            parcel?.writeInt(input.size)
            for (item in input) {
                parcel?.writeParcelable(Parcels.wrap<MarvelCharacter>(item), 0)
            }
        }
    }
}