package com.example.eventmanagerrecyclerview.UpcomingEvents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventmanagerrecyclerview.R
import com.google.android.material.card.MaterialCardView

class UpcomingEventAdapter: RecyclerView.Adapter<UpcomingEventAdapter.ViewHolder>() {
    var items = listOf<UpcomingEvents>()
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
            .inflate(R.layout.upcoming_item_view, parent, false) as MaterialCardView

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var singleItem = items[position]
        holder.eventTitle.text = singleItem.eventTitle
        holder.eventDate.text = "Date: " + singleItem.eventDate
        holder.eventDescription.text = "Description: " + singleItem.eventDescription
        holder.eventSponsor.text = "Sponsored by: " + singleItem.eventSponsor
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val eventTitle: TextView = itemView.findViewById(R.id.event_title)
        val eventDate: TextView = itemView.findViewById(R.id.event_date)
        val eventDescription: TextView = itemView.findViewById(R.id.event_description)
        val eventSponsor: TextView = itemView.findViewById(R.id.event_sponsor)
    }
}