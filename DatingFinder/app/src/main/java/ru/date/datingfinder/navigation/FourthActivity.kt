package ru.date.datingfinder.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fourth.*
import kotlinx.android.synthetic.main.activity_second.btn_next
import ru.date.datingfinder.R
import ru.date.datingfinder.database.SharedPrefManager

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        btn_next.setOnClickListener {
            val index: Int =
                choose_type.indexOfChild(findViewById(choose_type.checkedRadioButtonId))
            if (index==0){
                SharedPrefManager.getInstance(this).savereg(0)
            }
            else{
                SharedPrefManager.getInstance(this).savereg(1)
            }

            startActivity(Intent(this, FifthActivity::class.java))
            finish()
        }
    }
}