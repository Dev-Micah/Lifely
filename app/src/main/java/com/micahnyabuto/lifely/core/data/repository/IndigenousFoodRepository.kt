package com.micahnyabuto.lifely.core.data.repository

import com.micahnyabuto.lifely.core.data.local.IndigenousFood

import android.content.Context

class IndigenousFoodRepository(private val context: Context) {

    fun loadFoods(): List<IndigenousFood> {
        val foods = mutableListOf<IndigenousFood>()
        context.assets.open("indigenous_foods.csv").bufferedReader().useLines { lines ->
            lines.drop(1).forEach { line ->
                println("Line: $line")
                val tokens = line.split(",")
                if (tokens.size >= 5) {
                    val food = IndigenousFood(
                        name = tokens[0],
                        category = tokens[1],
                        calories = tokens[2].toIntOrNull() ?: 0,
                        healthBenefits = tokens[3],
                        imageName = tokens[4]
                    )
                    println("Loaded: $food")
                    foods.add(food)
                }
            }
        }
        return foods
    }
}
