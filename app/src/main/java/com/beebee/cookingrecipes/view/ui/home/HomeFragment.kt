package com.beebee.cookingrecipes.view.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.beebee.cookingrecipes.R
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.view.custom_view.home.HomeFoodViews
import com.beebee.cookingrecipes.view.custom_view.home.HomeListView
import com.beebee.cookingrecipes.viewmodel.home.HomeViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var listContent: HomeListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
            .apply {
                listContent = this as HomeListView
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderImage()
        bindViewModel()
        setContent()
    }

    private fun renderImage() {
        Glide.with(this@HomeFragment)
            .load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80")
            .into(profile_pic)
    }

    private fun setContent() {
        listContent.initView(viewModel)
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.foodList.observe(viewLifecycleOwner, Observer {
            listContent.updateList(it)
        })
    }
}
