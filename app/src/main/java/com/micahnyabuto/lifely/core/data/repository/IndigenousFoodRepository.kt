package com.micahnyabuto.lifely.core.data.repository

import com.micahnyabuto.lifely.core.data.local.IndigenousFood

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IndigenousFoodRepository(private val context: Context) {

    fun loadFoods(): List<IndigenousFood> {
        fun loadFoods(): List<IndigenousFood> {
            val jsonString = context.assets.open("indigenous_foods.json")
                .bufferedReader().use { it.readText() }

            val gson = Gson()
            val listType = object : TypeToken<List<IndigenousFood>>() {}.type

            return gson.fromJson(jsonString, listType)
        }
        return loadFoods()
    }
}
