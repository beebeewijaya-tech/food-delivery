package com.beebee.cookingrecipes.model.food

interface IFoodRoom {
    fun createFood(food: Food, callback: () -> Unit)
    fun updateFood(food: Food, callback: () -> Unit)
    fun deleteFood(food: Food, callback: () -> Unit)
    fun getFood(): List<Food>

    fun getFakeData(): List<Food>
}