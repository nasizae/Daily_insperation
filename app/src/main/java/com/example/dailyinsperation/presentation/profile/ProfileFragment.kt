package com.example.dailyinsperation.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dailyinsperation.R
import com.example.dailyinsperation.core.base.BaseFragment
import com.example.dailyinsperation.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding,ProfileViewModel>(R.layout.fragment_profile) {
    override val viewModel: ProfileViewModel
        get() = ProfileViewModel()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
      return  FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun initView() {

    }


}