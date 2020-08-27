package org.rec.datingapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_human_details.*
import kotlinx.android.synthetic.main.item_container.view.*
import java.io.Serializable

class HumanDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_human_details)

        val human = intent.getSerializableExtra("human") as HumanModel
        Log.e("messages msg", human.message.msg)
        Glide.with(this)
            .load(human.imageURL)
            .placeholder(R.drawable.ic_user)
            .into(image)
        name_age_tv.text = "${human.name}, ${human.age}"
        distance_tv.text = human.distance
        if(human.liked){
            hear_btn.setImageResource(R.drawable.ic_icn_heart_on_big)
        }
        desc_tv.text = human.description

        hear_btn.setOnClickListener {
            if (human.liked) {
                hear_btn.setImageResource(R.drawable.ic_icn_heart_off_big)
                human.liked=false
            }
            else {
                hear_btn.setImageResource(R.drawable.ic_icn_heart_on_big)
                human.liked=true

                val intent = Intent(this, PrivateChatActivity::class.java)
                intent.putExtra("human", human as Serializable)
                startActivity(intent)
            }
        }

        back_btn.setOnClickListener {
            finish()
        }


    }
}