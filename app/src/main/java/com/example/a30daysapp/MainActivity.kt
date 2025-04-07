package com.example.a30daysapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import TipAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipAdapter

    fun loadData(): MutableList<Tip> {
        val tips = mutableListOf<Tip>()

        for (i in 1..30) {
            val shortAdviceResId = resources.getIdentifier("short_advice_$i", "string", packageName)
            val longAdviceResId = resources.getIdentifier("long_advice_$i", "string", packageName)

            val shortAdvice = getString(shortAdviceResId)
            val longAdvice = getString(longAdviceResId)

            // Формируем имя ресурса изображения
            val imageResId = resources.getIdentifier("image$i", "drawable", packageName)

            // Создаем объект Tip с загруженными данными
            tips.add(Tip("День $i", shortAdvice, imageResId, longAdvice))
        }

        return tips
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tips = loadData() // Загрузка данных
        adapter = TipAdapter(tips)
        recyclerView.adapter = adapter
    }
}
