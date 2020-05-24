package com.beebee.cookingrecipes.model.food

import javax.inject.Inject

class FoodRoom @Inject constructor() : IFoodRoom {
    override fun createFood(food: Food, callback: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateFood(food: Food, callback: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFood(food: Food, callback: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFood(): List<Food> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFakeData(): List<Food> = listOf(
        Food(
            "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",
            "Salad",
            "Delicious salad for your health!",
            12,
            10,
            false
        ),
        Food(
            "https://images.unsplash.com/photo-1484723091739-30a097e8f929?ixlib=rb-1.2.1&auto=format&fit=crop&w=987&q=80",
            "Toast with Caramel",
            "Baked Toast poured by heated caramel on top of it.",
            32,
            5,
            true
        ),
        Food(
            "https://images.unsplash.com/photo-1506354666786-959d6d497f1a?ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80",
            "Pizza meat",
            "Italian Pizza that ingeredients are based on fresh meat from ribs",
            5,
            20,
            false
        )
    )
}