package com.beebee.cookingrecipes.base

import com.beebee.cookingrecipes.model.food.FoodRoom
import com.beebee.cookingrecipes.model.food.IFoodRoom
import toothpick.Toothpick
import toothpick.config.Module

object BaseApplicationModule {
    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}


object ApplicationModule: Module() {
    init {
        bind(IFoodRoom::class.java).toInstance(FoodRoom())
    }
}