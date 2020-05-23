package com.beebee.cookingrecipes.view.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.beebee.cookingrecipes.R
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.view.custom_view.home.HomeFoodViews

class HomeAdapter(
    val food: MutableList<Food> = mutableListOf(),
    val daDelegate: HomeTaskInterface
): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind (food: Food, foodIndex: Int) {
            (view as HomeFoodViews).initView(food) { isLiked, likeCount ->
                daDelegate.onLikeUpdated(foodIndex, isLiked, likeCount)
            }
        }
    }

    fun updateList(updatedFood: List<Food>) {
        val diffResult = DiffUtil.calculateDiff(FoodListCallback(updatedFood, food))
        food.clear()
        food.addAll(updatedFood)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = food.size

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bind(food[position], position)
    }


    class FoodListCallback(private val oldList: List<Food>, private val newList: MutableList<Food>): DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].like == newList[newItemPosition].like
    }
}
