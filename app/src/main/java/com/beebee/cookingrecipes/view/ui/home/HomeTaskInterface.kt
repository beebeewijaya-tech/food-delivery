package com.beebee.cookingrecipes.view.ui.home

interface HomeTaskInterface {
    fun onLikeUpdated(foodIndex: Int, isLiked: Boolean, foodLike: Int)
}