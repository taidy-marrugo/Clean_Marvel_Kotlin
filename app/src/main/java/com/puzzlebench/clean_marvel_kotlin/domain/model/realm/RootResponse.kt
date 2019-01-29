package com.puzzlebench.clean_marvel_kotlin.domain.model.realm

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.Parcel.Serialization
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel(Serialization.BEAN)
class RootResponse @ParcelConstructor constructor(@ParcelProperty ("code") val code: Int,
                                                  @ParcelProperty ("status") val status: String,
                                                  @ParcelProperty("copyright") val copyright: String,
                                                  @ParcelProperty("attributionText") val attributionText: String,
                                                  @ParcelProperty("attributionHTML") val attributionHTML: String,
                                                  @ParcelProperty("etag") val etag: String,
                                                  @ParcelProperty("data") val data: DataWrapper)