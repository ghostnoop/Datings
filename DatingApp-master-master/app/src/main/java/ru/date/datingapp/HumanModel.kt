package ru.date.datingapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class HumanModel(
    var name: String,
    var profession: String,
    var imageURL: String,
    var age: Int,
    var liked:Boolean,
    var message: Message
):Serializable, Parcelable