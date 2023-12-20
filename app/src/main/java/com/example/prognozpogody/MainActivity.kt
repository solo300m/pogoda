package com.example.prognozpogody

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = NewAdapter(listGenerate())
    }

    private fun listGenerate(): List<Prognoz> {
        var num = 1
        var list = mutableListOf<Prognoz>()
        for (i in 0..10) {
            if (num <= 7 && num > 0) {
                list.add(Prognoz(i, getDayName(num), getTemperature(), getSunny()))
                num++
            } else {
                num = 1
                list.add(Prognoz(i, getDayName(num), getTemperature(), getSunny()))
            }
        }
        return listOf(list) as List<Prognoz>
    }

    private fun getDayName(number: Int): String {
        var rez = when (number) {
            1 -> "Пн"
            2 -> "Вт"
            3 -> "Ср"
            4 -> "Чт"
            5 -> "Пт"
            6 -> "Сб"
            7 -> "Вс"
            else -> "No Name Day"
        }
        return rez
    }

    private fun getTemperature(): Int {
        return Random.nextInt(-30, 30)
    }

    private fun getSunny(): String = sunnyArr[(0..1).random()]

    companion object {
        val sunnyArr = listOf("sunny", "cloudy")
    }
}
