package com.micahnyabuto.lifely.features.foods


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.micahnyabuto.lifely.core.data.local.IndigenousFood
import com.micahnyabuto.lifely.core.data.repository.IndigenousFoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FoodViewModel(private val repository: IndigenousFoodRepository) : ViewModel() {

    private val _foods = MutableStateFlow<List<IndigenousFood>>(emptyList())
    val foods: StateFlow<List<IndigenousFood>> = _foods

    fun fetchFoods() {
        viewModelScope.launch {

            val loaded = repository.loadFoods()
            _foods.value = loaded
        }
    }
}
