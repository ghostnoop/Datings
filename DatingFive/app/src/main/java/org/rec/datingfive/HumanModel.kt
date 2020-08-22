package org.rec.datingfive

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class HumanModel(
    var name: String,
    var description: String,
    var imageURL: String,
    var age: Int,
    var liked:Boolean,
    var distance: String,
    var message: Message
):Serializable, Parcelable