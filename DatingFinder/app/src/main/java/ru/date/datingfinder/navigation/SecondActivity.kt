package ru.date.datingfinder.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import ru.date.datingfinder.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setUI()
    }

    fun setUI() {

        numberpicker.maxValue = 100
        numberpicker.minValue = 16

        btn_next.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
            finish()
        }
    }


}