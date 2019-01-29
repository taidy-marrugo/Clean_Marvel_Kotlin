package com.puzzlebench.clean_marvel_kotlin.domain.model.realm


import com.google.gson.annotations.SerializedName
import com.puzzlebench.clean_marvel_kotlin.domain.model.realm.realmconverters.CharacterUrlRealmListConverter
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import org.parceler.Parcel
import org.parceler.Parcel.Serialization
import org.parceler.ParcelPropertyConverter

@RealmClass
@Parcel(Serialization.BEAN)
open class MarvelCharacter : RealmObject() {
    @SerializedName("id") @PrimaryKey open var id: Long = 0
    @SerializedName("name") open var name: String? = ""
    @SerializedName("description") open var description: String? = ""
    @SerializedName("modified") open var modified: String? = ""
    @SerializedName("thumbnail") open var thumbnail: CharacterThumbnail? = CharacterThumbnail()
    @SerializedName("resourceURI") open var resourceUri: String? = ""
    @SerializedName("comics") open var comics: MarvelComics? = MarvelComics()
    @SerializedName("series") open var series: MarvelSeries? = MarvelSeries()
    @SerializedName("stories") open var stories: MarvelStories? = MarvelStories()
    @SerializedName("events") open var events: MarvelEvents? = MarvelEvents()
    @SerializedName("urls") open var urls: RealmList<CharacterUrl>? = RealmList()
        @ParcelPropertyConverter(CharacterUrlRealmListConverter::class) set
}