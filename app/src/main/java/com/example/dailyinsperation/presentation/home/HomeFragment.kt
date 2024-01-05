package com.example.dailyinsperation.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dailyinsperation.R
import com.example.dailyinsperation.core.base.BaseFragment
import com.example.dailyinsperation.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel
        get() = HomeViewModel()


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
    }
}