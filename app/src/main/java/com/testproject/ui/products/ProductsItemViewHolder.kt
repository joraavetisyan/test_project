package com.testproject.ui.products

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.testproject.R
import com.testproject.data.model.Product
import com.testproject.di.component.ViewHolderComponent
import com.testproject.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.product_item_view.view.*

class ProductsItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Product, ProductsItemViewModel>(R.layout.product_item_view, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.product_name.text = it
        })

        viewModel.price.observe(this, Observer {
            itemView.product_price.text = it.toString()
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}