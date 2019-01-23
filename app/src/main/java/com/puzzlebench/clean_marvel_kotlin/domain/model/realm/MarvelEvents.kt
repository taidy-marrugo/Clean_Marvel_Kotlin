package com.puzzlebench.clean_marvel_kotlin.domain.model.realm


import com.google.gson.annotations.SerializedName
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmconverters.MarvelItemRealmListConverter
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import org.parceler.Parcel
import org.parceler.Parcel.Serialization
import org.parceler.ParcelPropertyConverter

@RealmClass
@Parcel(Serialization.BEAN)
open class MarvelEvents : RealmObject() {
    @SerializedName("available") open var available: Int = 0
    @SerializedName("collectionURI") open var collectionUri: String? = ""
    @SerializedName("items") open var items: RealmList<MarvelItem> = RealmList()
        @ParcelPropertyConverter(MarvelItemRealmListConverter::class) set
    @SerializedName("returned") open var returned: Int = 0
}