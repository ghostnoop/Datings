package ru.date.datingfinder

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import org.json.JSONObject
import kotlin.random.Random
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_chat.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import ru.date.datingfinder.database.MessagesDb
import ru.date.datingfinder.models.HumanModel
import ru.date.datingfinder.models.Message
import ru.date.datingfinder.models.PrivateChatAdapter
import java.io.IOException

class ChatActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        MessagesDb.get(application)
        setUI()
    }

    @SuppressLint("SetTextI18n")
    fun setUI() {
        val human = intent.getSerializableExtra("human") as HumanModel
        Log.e("messages msg", human.message.msg)
        Glide.with(this)
            .load(human.imageURL)
            .circleCrop()
            .placeholder(R.drawable.ic_user)
            .into(profile)
        name.text = human.name
        age.text = "${human.age} yo"

        chat_messages.layoutManager = LinearLayoutManager(this)
        val messages: ArrayList<Message> = arrayListOf()
        val chatId: Int = human.message.chat_id
        val adapter = PrivateChatAdapter(messages) {

        }
        chat_messages.adapter = adapter

        Log.d("messages chat_id", chatId.toString())

        MessagesDb.get(application).getMessagesDao().getMessagesByChatId(chatId)
            .observe(this, Observer {

                for (message in it) {
                    messages.add(message)
                    Log.d("messages", message.toString())
                }
                adapter.notifyDataSetChanged()
                bar.visibility = View.GONE
            })
        val answers = initAnswers()
        message_send_btn.setOnClickListener {

            if (message_editor_et.text.isNotEmpty()) {


                doAsync {
                    MessagesDb.get(application).getMessagesDao().insert(
                        Message(
                            Random.nextInt(),
                            chatId,
                            message_editor_et.text.toString(),
                            "me"
                        )
                    )
                    messages.add(
                        Message(
                            Random.nextInt(),
                            chatId,
                            message_editor_et.text.toString(),
                            "me"
                        )
                    )

                    activityUiThread {
                        adapter.notifyDataSetChanged()
                        message_editor_et.text.clear()
                        chat_messages.scrollToPosition(messages.size - 1)
                        Thread.sleep(1000)
                        doAsync {
                            MessagesDb.get(application).getMessagesDao().insert(
                                Message(
                                    Random.nextInt(), chatId,
                                    answers[Random.nextInt(100)], human.name
                                )
                            )
                            messages.add(
                                Message(
                                    Random.nextInt(), chatId,
                                    answers[Random.nextInt(100)], human.name
                                )
                            )
                            activityUiThread {
                                adapter.notifyDataSetChanged()
                                chat_messages.scrollToPosition(messages.size - 1)
                            }
                        }
                    }
                }
            }
        }
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    fun initAnswers(): List<String> {
        val answers: ArrayList<String> = arrayListOf()

        val jsonFileString = getJsonDataFromAsset(applicationContext, "sentences.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }
        val jsonObject = JSONObject(jsonFileString)
        val jsonArray = jsonObject.optJSONArray("data")
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val sentence = jsonObject.optString("sentence")
            answers.add(sentence)
            Log.i("data_sentences", sentence)
        }
        return answers
    }

}