package com.example.dailyinsperation.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.dailyinsperation.data.model.CategoryModel
import com.example.dailyinsperation.databinding.ItemCategoryBinding

class CategoryAdapter : Adapter<CategoryAdapter.CategoryHolder>() {

    var data = arrayListOf(
        CategoryModel("мотивация", "https://ouch-cdn2.icons8.com/IzBmYHUbagyVZqXQXn6WLhgL3S3AkIXwwdH8EIOq06E/rs:fit:368:294/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvMTI5/LzIyMjc5YjZmLWNi/OTAtNGZkNS04M2Zj/LWZkNmU0MGFhN2Jl/NC5zdmc.png"),
        CategoryModel("Любовь", "https://ouch-cdn2.icons8.com/AMrDbs9NAYRC49lfC1B0G9mPS1QrQEW_hBdOJBmLKq8/rs:fit:368:207/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvODg3/LzlmOTY3MTJkLTBm/MjQtNDQ3Zi05ZDUw/LTkzM2U4NzY1OGZh/Ni5zdmc.png"),
        CategoryModel("Жизнь", "https://ouch-cdn2.icons8.com/2fOir2eh-nxHRTh9x9TgbkOM-RQif1Rrvf3XYKg2Oos/rs:fit:368:276/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvNDY3/L2Y0NjBkOTRhLWJj/NTEtNDBhNy1hMWJh/LWI2NTFkYTdlNDli/YS5zdmc.png"),
        CategoryModel("смешные", "https://ouch-cdn2.icons8.com/Dy0SEtEEohzbneOrMEGnPVULX9hFAK5wX-Vpx-2sKn8/rs:fit:368:226/czM6Ly9pY29uczgu/b3VjaC1wcm9kLmFz/c2V0cy9zdmcvNjMz/LzRlODM2YzFkLTVh/OWItNGFiYS1iMWE3/LWUwNDNiM2Q5MGQ0/NC5zdmc.png"),

        )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
      return CategoryHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class CategoryHolder(private val binding: ItemCategoryBinding) :
        ViewHolder(binding.root) {
        fun bind(categoryModel: CategoryModel) {
            binding.tvCategory.text = categoryModel.name
            binding.imgCategory.load(categoryModel.img)
        }
    }
}
