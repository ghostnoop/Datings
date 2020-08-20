package ru.date.datingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.android.synthetic.main.activity_main.*
import ru.date.datingapp.database.SharedPrefManager


class MainActivity : AppCompatActivity() {
    private val US_IN = listOf("us", "in")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseFirestore.getInstance()
        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

//        val ans =
//            US_IN.contains(manager.simCountryIso) && manager.simOperatorName.isNotEmpty()
//
//        if (ans) {
//            setUi()
//        } else
//            getURL()
        setUi()


    }

    private fun getURL() {

        val g = FirebaseFirestore.getInstance();
        val h = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(false)
            .build()

        g.firestoreSettings = h
        var oBool = false

        g.collection("data").get().addOnCompleteListener { task ->

            if (task.isSuccessful) for (document in task.result!!)
                if (document.data["value"].toString().length > 1) {

                    oBool = true
                    val message = document.data["value"] as String
                    goLink(message)

                }
            if (!oBool) setUi()
        }.addOnFailureListener { setUi() }
    }

    private fun goLink(url: String) {
        val i = Intent(this, WebActivity::class.java)
        i.putExtra("url", url)
        startActivity(i)
        finish()
    }

    private fun setUi() {
        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(this, DiscoverActivity::class.java)
            intent.putExtra("gender",SharedPrefManager.getInstance(this).isreg)
            startActivity(intent)
        }


        pg_bar.visibility = View.GONE
        ll_view.visibility = View.VISIBLE

        day_sp.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.Days)
            )
        )

        month_sp.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.Mounth)
            )
        )
        year_sp.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.Year)
            )
        )
        me_sp.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                listOf("Man", "Woman")
            )
        )
        look_sp.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                listOf("Woman", "Man")
            )
        )

        btn_next.setOnClickListener {


            if (checkAll()) {
                val genders=look_sp.text.toString()
                var gender=0
                if (genders.equals("Man"))
                    gender=1
                SharedPrefManager.getInstance(this).savereg(gender)
                SharedPrefManager.getInstance(this).setLogin()

                val intent = Intent(this, DiscoverActivity::class.java)
                intent.putExtra("gender",gender)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Some field is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkAll(): Boolean {
        val personName = person_name.text.toString()
        val birthDay = day_sp.text.toString()
        val birthMonth = month_sp.text.toString()
        val birthYear = year_sp.text.toString()
        val me = me_sp.text.toString()
        val searchFor = look_sp.text.toString()

        if (personName.isEmpty()) return false
        if (birthDay.isEmpty()) return false
        if (birthMonth.isEmpty()) return false
        if (birthYear.isEmpty()) return false
        if (me.isEmpty()) return false
        if (searchFor.isEmpty()) return false
        return true
    }





}