package com.puzzlebench.clean_marvel_kotlin.domain.model.realm

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.Parcel.Serialization
import org.parceler.ParcelConstructor

@Parcel(Serialization.BEAN)
class RootResponse @ParcelConstructor constructor(@SerializedName("code") val code: Int,
                   @SerializedName("status") val status: String,
                   @SerializedName("copyright") val copyright: String,
                   @SerializedName("attributionText") val attributionText: String,
                   @SerializedName("attributionHTML") val attributionHTML: String,
                   @SerializedName("etag") val etag: String,
                   @SerializedName("data") val data: DataWrapper)