package com.example.eventmanagerrecyclerview.Staff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventmanagerrecyclerview.R
import com.google.android.material.card.MaterialCardView

class StaffAdapter: RecyclerView.Adapter<StaffAdapter.ViewHolder>() {
    var items = listOf<Staff>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.staff_item_view, parent, false) as MaterialCardView

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var singleItem = items[position]
        holder.staffPicture.setImageResource(R.mipmap.ic_blank_profile_picture_round)
        holder.staffName.text = singleItem.name
        holder.staffAge.text = singleItem.age.toString() + " years old"
        holder.staffBio.text = "Biography: " + singleItem.biography
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val staffPicture: ImageView = itemView.findViewById(R.id.staff_profile_picture)
        val staffName: TextView = itemView.findViewById(R.id.staff_name)
        val staffAge: TextView = itemView.findViewById(R.id.staff_age)
        val staffBio: TextView = itemView.findViewById(R.id.staff_bio)
    }
}