package com.testproject.ui.categories

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.testproject.data.model.Category
import com.testproject.ui.base.BaseAdapter

class CategoriesAdapter(
    parentLifecycle: Lifecycle,
    private val categories: ArrayList<Category>
) : BaseAdapter<Category, CategoriesItemViewHolder>(parentLifecycle, categories) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoriesItemViewHolder(parent)


}