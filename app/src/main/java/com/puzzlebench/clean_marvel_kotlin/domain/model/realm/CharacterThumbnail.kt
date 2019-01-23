package com.puzzlebench.clean_marvel_kotlin.domain.model.realm


import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.RealmClass
import org.parceler.Parcel
import org.parceler.Parcel.Serialization

@RealmClass
@Parcel(Serialization.BEAN)
open class CharacterThumbnail : RealmObject() {
    @SerializedName("path") open var path: String? = ""
    @SerializedName("extension") open var extension: String? = ""
}