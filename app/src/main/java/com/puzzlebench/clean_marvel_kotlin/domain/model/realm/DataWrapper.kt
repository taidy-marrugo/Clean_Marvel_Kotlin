package com.puzzlebench.clean_marvel_kotlin.domain.model.realm
import com.google.gson.annotations.SerializedName
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.parcelconverters.MarvelCharacterListConverter
import org.parceler.Parcel
import org.parceler.Parcel.Serialization
import org.parceler.ParcelConstructor
import org.parceler.ParcelPropertyConverter

@Parcel(Serialization.BEAN)
class DataWrapper @ParcelConstructor constructor (
        @SerializedName("offset") val offset: Int,
        @SerializedName("limit") val limit: Int,
        @SerializedName("total") val total: Int,
        @SerializedName("count") val count: Int) {

    @SerializedName("results") var results: List<MarvelCharacter> = emptyList()
        @ParcelPropertyConverter(MarvelCharacterListConverter::class) set
}



