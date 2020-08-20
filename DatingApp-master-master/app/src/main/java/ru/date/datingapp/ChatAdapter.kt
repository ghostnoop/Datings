package ru.date.datingapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_chat.view.*

class ChatAdapter(private val humans: List<HumanModel>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<ChatAdapter.HumanModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanModelViewHolder {
        return HumanModelViewHolder(inflate(parent.context, R.layout.item_chat, parent, false))
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

            Glide.with(itemView)
                .load(human.imageURL)
                .circleCrop()
                .placeholder(R.drawable.ic_user)
                .into(itemView.profile)
            itemView.name.text = human.name
            itemView.time_last.text = human.message.time
            itemView.message.text = human.message.msg

            if (human.message.read) {
                itemView.read_bool.visibility = View.GONE
            }


            itemView.setOnClickListener { listener(adapterPosition) }
        }
    }

}