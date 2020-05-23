package com.beebee.cookingrecipes.view.custom_view.home

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.beebee.cookingrecipes.R
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.view.ui.home.HomeAdapter
import com.beebee.cookingrecipes.view.ui.home.HomeFragmentDirections
import com.beebee.cookingrecipes.viewmodel.home.HomeViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.food_list_row.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFoodViews @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    fun initView(food: Food, onLikedUpdateCallback: (Boolean, Int) -> Unit) {
        food_title.text = food.title
        food_description.text = food.description
        food_time.text = food.time.toString()
        food_like.text = food.like.toString()
        renderFoodLiked(food)

        Glide.with(this)
            .load(food.image)
            .into(food_photo)

        food_photo.setOnClickListener {
            val actionToDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                food
            )
            findNavController().navigate(actionToDetail)
        }

        love_icon.setOnClickListener { setLikeFood(food, onLikedUpdateCallback) }
    }

    private fun setLikeFood(food: Food, callback: (Boolean, Int) -> Unit) {
        food.isLike = !food.isLike
        val foodCount = if (!food.isLike) {
            food.like - 1
        } else {
            food.like + 1
        }

        callback.invoke(food.isLike, foodCount)
        renderFoodLiked(food)
    }

    private fun renderFoodLiked(food: Food) {
        if (food.isLike) {
            setHeartLike()
        } else {
            setHeartLikeOutline()
        }
        food_like.text = food.like.toString()
    }

    private fun setHeartLike() {
        love_icon.setImageResource(R.drawable.ic_heart_fill_brown)
    }

    private fun setHeartLikeOutline() {
        love_icon.setImageResource(R.drawable.ic_love_icon)
    }
}