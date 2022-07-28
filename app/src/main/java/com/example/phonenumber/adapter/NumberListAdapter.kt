package com.example.phonenumber.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonenumber.R
import com.example.phonenumber.model.NumberModel
import com.example.phonenumber.network.ClickListener

class NumberListAdapter(
    private var mContext: Context,
    private var numberlist: ArrayList<NumberModel>, var itemClicked: ClickListener
) :
    RecyclerView.Adapter<NumberListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberListHolder {
        var view =
            LayoutInflater.from(mContext).inflate(R.layout.numberlist, parent, false)
        return NumberListHolder(view)

    }


    override fun onBindViewHolder(holder: NumberListHolder, position: Int) {

        holder.tvName.text = numberlist[position].name
        holder.tvNumber.text = numberlist[position].number

        holder.cardView.setOnClickListener {
            itemClicked.onClickItem(position)
        }
    }

    override fun getItemCount(): Int {
        return numberlist.size
    }



}

class NumberListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName = itemView.findViewById<TextView>(R.id.tvName)
    var tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
    var cardView=itemView.findViewById<CardView>(R.id.card)


}