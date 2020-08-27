package org.rec.datingfive.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.rec.datingapplication.Message

@Dao
interface MessagesDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(message: Message)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultiple(message: List<Message>)

    @Query("SELECT * FROM messages ")
    fun getMessages(): LiveData<List<Message>>

    @Query("SELECT * FROM messages WHERE name like :username")
    fun getMessagesByUser(username: String): LiveData<List<Message>>

    @Query("SELECT * FROM messages WHERE chat_id like :chat_id ORDER BY id DESC LIMIT 1")
    fun getLastMessageByChatId(chat_id: Int): LiveData<Message>

    @Query("SELECT * FROM messages WHERE chat_id IN (SELECT DISTINCT MAX(chat_id) FROM messages  ORDER BY id DESC)")
    fun getLastMessagesOfChats(): LiveData<List<Message>>

    @Query("SELECT DISTINCT chat_id FROM messages ORDER BY id DESC")
    fun getChatIds(): LiveData<List<Int>>

    @Query("SELECT COUNT(DISTINCT chat_id) FROM messages")
    fun getChatsCount(): LiveData<Int>

    @Query("SELECT * FROM messages WHERE chat_id = :chat_id ORDER BY id ASC")
    fun getMessagesByChatId(chat_id: Int): LiveData<List<Message>>

}