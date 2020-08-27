package org.rec.datingapplication

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Entity(tableName = "messages")
@Parcelize
class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "chat_id") var chat_id: Int,
    @ColumnInfo(name = "message") var msg: String = "",
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "last_time") var time: String = "23 min",
    @ColumnInfo(name = "read") var read: Boolean = true
):Serializable, Parcelable