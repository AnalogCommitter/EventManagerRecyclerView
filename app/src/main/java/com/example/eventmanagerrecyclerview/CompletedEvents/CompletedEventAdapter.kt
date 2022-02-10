package com.example.eventmanagerrecyclerview.CompletedEvents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventmanagerrecyclerview.R
import com.google.android.material.card.MaterialCardView

class CompletedEventAdapter: RecyclerView.Adapter<CompletedEventAdapter.ViewHolder>() {
    var items = listOf<CompletedEvents>()
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
            .inflate(R.layout.completed_item_view, parent, false) as MaterialCardView

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var singleItem = items[position]
        holder.title.text = singleItem.title
        holder.completionDate.text = "Completed on " + singleItem.completeDate
        holder.overview.text = "Overview: " + singleItem.overview
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.completed_event_title)
        val completionDate: TextView = itemView.findViewById(R.id.complete_date)
        val overview: TextView = itemView.findViewById(R.id.completed_event_overview)
    }
}