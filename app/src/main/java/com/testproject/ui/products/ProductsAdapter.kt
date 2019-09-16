package com.testproject.ui.products

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.testproject.data.model.Product
import com.testproject.ui.base.BaseAdapter

class ProductsAdapter(
    parentLifecycle: Lifecycle,
    private val products: ArrayList<Product>
) : BaseAdapter<Product, ProductsItemViewHolder>(parentLifecycle, products) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductsItemViewHolder(parent)
}