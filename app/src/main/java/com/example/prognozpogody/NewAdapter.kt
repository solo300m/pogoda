package com.example.prognozpogody

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(private val news: List<Prognoz>):RecyclerView.Adapter<NewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_wether, parent, false)
        return NewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
       holder.bind(news[position])
    }
}
