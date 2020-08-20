package ru.date.datingfinder.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import ru.date.datingfinder.R

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)
        btn_next.setOnClickListener {
            startActivity(Intent(this, SixthActivity::class.java))
            finish()
        }
    }
}