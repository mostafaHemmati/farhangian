package com.hemmati.farhangian.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hemmati.farhangian.R
import com.hemmati.farhangian.di.BASE_URL
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_category.view.*
import kotlin.properties.Delegates

class SubCategoryAdapter :
    RecyclerView.Adapter<SubCategoryAdapter.CategoryViewHolder>() {

    var onItemClick: ((SubCategoryData) -> Unit)? = null
    var itemList: List<SubCategoryData> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_category,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(itemList[position])

    }

    override fun getItemCount(): Int = if (itemList.isNullOrEmpty()) 0 else itemList.size


    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(subCategoryData: SubCategoryData) {

            itemView.setOnClickListener { onItemClick?.invoke(subCategoryData) }
            itemView.title.text = subCategoryData.subCategoryName
            itemView.number.text = "(${subCategoryData.filesCount})"
            Picasso.get()
                .load(BASE_URL + "files/" + subCategoryData.subCategoryPic)
                .placeholder(R.drawable.ic_baseline)
                .fit()
                .error(R.drawable.ic_baseline).into(itemView.categoryImg)

        }

    }

}