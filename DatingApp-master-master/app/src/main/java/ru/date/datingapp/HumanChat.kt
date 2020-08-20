package ru.date.datingapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
class HumanChat(
    var Last_message: Message,
    var Last_time: String,
    var Read: Boolean
):Serializable, Parcelable