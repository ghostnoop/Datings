package ru.date.datingfinder

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_finder.*
import ru.date.datingfinder.database.SharedPrefManager
import ru.date.datingfinder.models.HumanModel
import java.io.Serializable

class FinderActivity : AppCompatActivity() {
    lateinit var rocketAnimation: AnimationDrawable
    lateinit var countdown_timer: CountDownTimer
    lateinit var human: HumanModel
    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finder)
        val rocketImage = findViewById<ImageView>(R.id.rocket_image).apply {
            setBackgroundResource(R.drawable.animated_logo)
            rocketAnimation = background as AnimationDrawable
        }
        rocketAnimation.start()


        val index = SharedPrefManager.getInstance(this).isreg
        human = if (index == 0) {
            getMan()
        } else {
            getGirl()
        }

        Log.e("N@@", human.name)
        with(human) {
            Glide.with(applicationContext).load(imageURL).placeholder(R.drawable.ic_user)
                .circleCrop()
                .into(profile_image)
            name_age_tv.text = "${name}, ${age}"
            description_tv.text = profession

        }

        val timeInSeconds = 5000L
        var timeInMilliSeconds = 0L

        countdown_timer = object : CountDownTimer(timeInSeconds, 1000) {
            override fun onFinish() {
                setUI()
            }

            override fun onTick(p0: Long) {
                timeInMilliSeconds = p0
            }
        }
        countdown_timer.start()

        isRunning = true


    }

    fun setUI() {
        mainUI.visibility = View.VISIBLE
        Thread.sleep(100)
        waiterRL.visibility = View.GONE

        btn_next.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("human", human as Serializable)
            startActivity(intent)
        }
    }


}