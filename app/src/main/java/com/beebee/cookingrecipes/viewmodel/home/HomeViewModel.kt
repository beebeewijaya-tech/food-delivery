package com.beebee.cookingrecipes.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.model.food.FoodRoom
import com.beebee.cookingrecipes.view.ui.home.HomeTaskInterface

class HomeViewModel : ViewModel(), HomeTaskInterface {
    private val foodRoom = FoodRoom()

    private val _foodListLiveData: MutableLiveData<List<Food>> = MutableLiveData()
    val foodList = _foodListLiveData

    init {
        this._foodListLiveData.postValue(foodRoom.getFakeData())
    }

    override fun onLikeUpdated(foodIndex: Int, isLiked: Boolean, foodLike: Int) {
        _foodListLiveData.value?.get(foodIndex)?.apply {
            isLike = isLiked
            like = foodLike
        }
    }
}