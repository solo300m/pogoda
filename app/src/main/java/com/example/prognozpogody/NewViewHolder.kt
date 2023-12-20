package com.example.prognozpogody

import android.annotation.SuppressLint
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewViewHolder(parentView:View):RecyclerView.ViewHolder(parentView) {
    private val dayName:TextView
    private val temperature: TextView
    private val sunSing:ImageView
    private var card:FrameLayout
    init{
        dayName = parentView.findViewById(R.id.day)
        temperature = parentView.findViewById(R.id.text)
        sunSing = parentView.findViewById(R.id.icon)
        card = parentView.findViewById(R.id.card)
    }
    @SuppressLint("ResourceAsColor")
    fun bind(model:Prognoz){
        dayName.text = model.day
        temperature.text = model.temperature.toString()
        if(model.sunny == "sunny"){
            sunSing.setImageResource(R.drawable.sunny_24)
        }else{
            sunSing.setImageResource(R.drawable.cloud_24)
        }
        if(model.temperature < -20){
            card.setBackgroundColor(R.color.blue_deep)
        }else if(-20 <= model.temperature && model.temperature < -10 ){
            card.setBackgroundColor(R.color.blue_middle)
        }else if(-10 <= model.temperature && model.temperature < -5 ){
            card.setBackgroundColor(R.color.blue)
        }else if(-5 <= model.temperature && model.temperature < 0 ){
            card.setBackgroundColor(R.color.gray)
        }else if(model.temperature >= 0 ){
            card.setBackgroundColor(R.color.gray_light)
        }

    }
}
