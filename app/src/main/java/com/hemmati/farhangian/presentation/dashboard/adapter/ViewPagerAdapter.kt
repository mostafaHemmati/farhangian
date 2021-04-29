package com.hemmati.farhangian.presentation.dashboard.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hemmati.farhangian.domain.model.category.CategoryData
import com.hemmati.farhangian.presentation.dashboard.podemanpages.PoodemanFragment

class ViewPagerAdapter(
    private val categories: List<CategoryData>,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun createFragment(position: Int): Fragment {
        val category = categories[position]
        return PoodemanFragment.createInstance(category.categoryId, category.categoryName)
    }
}