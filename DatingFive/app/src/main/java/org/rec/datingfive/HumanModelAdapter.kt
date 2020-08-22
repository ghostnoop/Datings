package org.rec.datingfive

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_container.view.*
import java.io.Serializable

class HumanModelAdapter(private val context: Context, private val humans: List<HumanModel>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<HumanModelAdapter.HumanModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanModelViewHolder {
        return HumanModelViewHolder(inflate(parent.context, R.layout.item_container, parent,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: HumanModelViewHolder,
        position: Int
    ) {
        holder.bind(humans[position], listener)
        val human: HumanModel = humans[position]
        Glide.with(holder.itemView).load(human.imageURL).centerInside().into(holder.itemView.image)

        holder.itemView.name_age_tv.text = human.name + ", " + human.age
        holder.itemView.distance_tv.text = human.distance
        holder.itemView.desc_tv.text =     human.description

        holder.itemView.accept_btn.setOnClickListener {
            val intent = Intent(context, PrivateChatActivity::class.java)
            intent.putExtra("human", human as Serializable)
            context.startActivity(intent)
        }

        holder.itemView.cancel_btn.setOnClickListener {
            listener(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return humans.size
    }


    class HumanModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(human: HumanModel, listener: (Int) -> Unit) = with(itemView) {



//            itemView.setOnClickListener { listener(adapterPosition) }
        }

    }


}