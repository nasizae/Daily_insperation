package com.example.dailyinsperation.presentation.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.dailyinsperation.data.model.OnBoardingModel
import com.example.dailyinsperation.databinding.ItemOnboardingBinding

class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.OnBoardingHolder>() {

    val data = arrayListOf(
        OnBoardingModel(
            "Добро пожаловать в наше приложение",
            "https://ouch-cdn2.icons8.com/SDaftzo6X17LBht_RfI4IO1sISAt2imytAKuGwCkKrA/rs:fit:368:276/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvMjQ4/L2I3NTFiNjE2LWU1/ZTctNDk5Mi04YjE2/LThiMmM4YzdhNWVk/Yi5zdmc.png"
        ),
        OnBoardingModel(
            "Получайте каждый день цитаты для поддерживания оптимистичного настроение.",
            "https://ouch-cdn2.icons8.com/g-sMpOqLumQom_j3JsDuDiXckYrddhWixdPNk_RmvEM/rs:fit:368:368/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvOTkv/Yjg0MWEzNDgtODJk/OS00YzNmLWI5NDIt/NDY1NDZhZTVmNDBk/LnN2Zw.png"
        ),
        OnBoardingModel(
            "Отправляйте друзьям цитаты которые вам понравились",
            "https://ouch-cdn2.icons8.com/JnEYFrsz1jST7HLpeJyxK2FsRvYzycQScgFCbcy-Q0g/rs:fit:368:254/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvOTE4/L2QzNTc2YjkzLTc3/ZDQtNDE0YS05NjQw/LTg2ZTIwZDVhZDA3/OS5zdmc.png"
        )
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingHolder {
     return OnBoardingHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoardingModel: OnBoardingModel) {
            binding.apply {
                tvTitle.text = onBoardingModel.title
                image.load(onBoardingModel.img)
                btnStart.isVisible = adapterPosition == data.lastIndex
                tvSkip.isVisible = adapterPosition != data.lastIndex

                btnStart.setOnClickListener {
                    onClick()
                }
                tvSkip.setOnClickListener {
                    onClick()
                }
            }

        }
    }
}