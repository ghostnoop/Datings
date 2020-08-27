package org.rec.datingapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import org.rec.datingapplication.MainActivity.Companion.getHUMANS
import org.rec.datingfive.database.MessagesDb

import java.io.Serializable

class ChatActivity : AppCompatActivity() {

    private val humans = getHUMANS()
    private var chatHumansList: ArrayList<HumanModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        MessagesDb.get(application).getMessagesDao().getChatIds()
            .observe(this, Observer {
                it.forEach{ its ->
                    MessagesDb.get(application).getMessagesDao().getLastMessageByChatId(its)
                        .observe(this, Observer { msg->
                            humans.forEach {
                                if (msg.chat_id == it.message.chat_id) {
                                    chatHumansList.add(HumanModel(it.name, it.description, it.imageURL, it.age, it.liked, it.distance, msg))
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