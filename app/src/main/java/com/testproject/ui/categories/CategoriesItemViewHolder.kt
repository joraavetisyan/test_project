package com.testproject.ui.categories

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.testproject.R
import com.testproject.data.model.Category
import com.testproject.data.model.Product
import com.testproject.di.component.ViewHolderComponent
import com.testproject.ui.base.BaseItemViewHolder
import com.testproject.ui.main.MainActivity
import kotlinx.android.synthetic.main.category_item_view.view.*

class CategoriesItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Category, CategoriesItemViewModel>(R.layout.category_item_view, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.title.observe(this, Observer {
            itemView.category_title.text = it
        })

        viewModel.description.observe(this, Observer {
            itemView.category_desc.text = it
        })

        viewModel.productsFragmentLiveData.observe(this, Observer {
            (itemView.context as MainActivity).showProductsFragment(it as ArrayList<Product>)
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }

}