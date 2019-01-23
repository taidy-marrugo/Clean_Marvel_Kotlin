package com.puzzlebench.clean_marvel_kotlin.domain.model.realm

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import org.parceler.Parcel
import org.parceler.Parcel.Serialization

@RealmClass
@Parcel(Serialization.BEAN, analyze = [MarvelItem::class])
open class MarvelItem: RealmObject() {
    @SerializedName("resourceURI") open var resourceUri: String? = ""
    @SerializedName("name") open var name: String? = ""
}