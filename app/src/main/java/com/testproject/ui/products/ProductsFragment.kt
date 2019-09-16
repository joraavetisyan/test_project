package com.testproject.ui.products

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.testproject.R
import com.testproject.data.model.Product
import com.testproject.di.component.FragmentComponent
import com.testproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.products_layout.*
import javax.inject.Inject

class ProductsFragment : BaseFragment<ProductsViewModel>() {

    override fun provideLayoutId() = R.layout.products_layout

    companion object {
        const val TAG = "ProductsFragment"
        private const val ARG_PRODUCTS = "products"

        fun newInstance(products: ArrayList<Product>): ProductsFragment {
            return ProductsFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PRODUCTS, products)
                }
            }
        }
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var productsAdapter: ProductsAdapter

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        rv_products.layoutManager = linearLayoutManager
        rv_products.adapter = productsAdapter
        if (arguments != null) {
            productsAdapter.appendData(arguments!!.getParcelableArrayList(ARG_PRODUCTS))
        }
    }

}