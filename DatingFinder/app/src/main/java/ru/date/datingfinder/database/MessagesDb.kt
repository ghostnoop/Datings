package ru.date.datingfinder.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.date.datingfinder.models.Message


@Database(version = 3, entities = [Message::class])
abstract class MessagesDb : RoomDatabase() {

    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE users "
                            + "ADD COLUMN address TEXT"
                )
            }
        }
        fun get(application: Application): MessagesDb {
            return Room.databaseBuilder(application, MessagesDb::class.java, "messages")
                .fallbackToDestructiveMigration()
                .build()
        }
    }



    abstract fun getMessagesDao(): MessagesDao
}