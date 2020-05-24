package com.beebee.cookingrecipes.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beebee.cookingrecipes.base.BaseApplicationModule
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.model.food.FoodRoom
import com.beebee.cookingrecipes.view.ui.home.HomeTaskInterface
import toothpick.Toothpick
import javax.inject.Inject

class HomeViewModel : ViewModel(), HomeTaskInterface {
    @Inject
    lateinit var foodModel: FoodRoom

    private val _foodListLiveData: MutableLiveData<List<Food>> = MutableLiveData()
    val foodList = _foodListLiveData

    init {
        Toothpick.inject(this, BaseApplicationModule.scope)
        this._foodListLiveData.postValue(foodModel.getFakeData())
    }

    override fun onLikeUpdated(foodIndex: Int, isLiked: Boolean, foodLike: Int) {
        _foodListLiveData.value?.get(foodIndex)?.apply {
            isLike = isLiked
            like = foodLike
        }
    }
}