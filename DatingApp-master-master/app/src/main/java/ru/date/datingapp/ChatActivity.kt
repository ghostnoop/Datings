package ru.date.datingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.collections.forEachReversedByIndex
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete
import ru.date.datingapp.database.MessagesDb
import ru.date.datingapp.database.SharedPrefManager
import java.io.Serializable

class ChatActivity : AppCompatActivity() {

    private val chatHumans: Set<HumanModel> = setOf()
    private var chatHumansList: ArrayList<HumanModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val gen = SharedPrefManager.getInstance(this).isreg
        var humans = listOf<HumanModel>()
        if (gen == 0)
           humans=DiscoverActivity.getHUMANSGIRl()
        else
            humans=DiscoverActivity.getHUMANSMan()


        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        MessagesDb.get(application).getMessagesDao().getChatIds()
            .observe(this, Observer {
                it.forEach{ it ->
                    MessagesDb.get(application).getMessagesDao().getLastMessageByChatId(it)
                        .observe(this, Observer { msg->
                            humans.forEach {
                                if (msg.chat_id == it.message.chat_id) {
                                    chatHumansList.add(HumanModel(it.name, it.profession, it.imageURL, it.age, it.liked, msg))
                                }
                                val adapter = ChatAdapter(chatHumansList) { adapterPosition ->
                                    if (!chatHumansList[adapterPosition].message.read) {
                                        chatHumansList[adapterPosition].message.read = true
                                    }

                                    val intent = Intent(applicationContext, PrivateChatActivity::class.java)
                                    intent.putExtra("human", chatHumansList[adapterPosition] as Serializable)
                                    startActivity(intent)

                                }
                                recyclerView.adapter = adapter
                                if (chatHumansList.size > 0) {
                                    advert.visibility = View.GONE
                                }
                                adapter.notifyDataSetChanged()
                            }
                        })

                }

            })

    }
}