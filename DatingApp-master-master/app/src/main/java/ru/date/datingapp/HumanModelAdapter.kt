package ru.date.datingapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_container.view.*
import java.io.Serializable

class HumanModelAdapter(private val context: Context,private val humans: List<HumanModel>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<HumanModelAdapter.HumanModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanModelViewHolder {
        return HumanModelViewHolder(inflate(parent.context, R.layout.item_container, parent, false))
    }

    override fun onBindViewHolder(
        holder: HumanModelViewHolder,
        position: Int
    ) {
        holder.bind(humans[position], listener)
    }

    override fun getItemCount(): Int {
        return humans.size
    }


    class HumanModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(human: HumanModel, listener: (Int) -> Unit) = with(itemView) {

//            bindingAdapterPosition
//            absoluteAdapterPosition

            Glide.with(itemView).load(human.imageURL).centerInside().into(itemView.image)

            itemView.name_age_tv.text = human.name + ", " + human.age
            itemView.prof_tv.text = human.profession

            if (human.liked)
                itemView.hear_btn.setImageResource(R.drawable.ic_icn_heart_on)
            else
                itemView.hear_btn.setImageResource(R.drawable.ic_icn_heart_off)

            itemView.hear_btn.setOnClickListener {
                if (human.liked) {
                    itemView.hear_btn.setImageResource(R.drawable.ic_icn_heart_off)
                    human.liked=false
                }
                else {
                    itemView.hear_btn.setImageResource(R.drawable.ic_icn_heart_on)
                    human.liked=true

                    val intent = Intent(context, PrivateChatActivity::class.java)
                    intent.putExtra("human", human as Serializable)
                    context.startActivity(intent)
                }
            }

            itemView.setOnClickListener { listener(adapterPosition) }
        }
    }

}