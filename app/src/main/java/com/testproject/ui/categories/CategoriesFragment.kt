package com.testproject.ui.categories

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.testproject.R
import com.testproject.di.component.FragmentComponent
import com.testproject.ui.base.BaseFragment
import kotlinx.android.synthetic.main.categories_layout.*
import javax.inject.Inject

class CategoriesFragment : BaseFragment<CategoriesViewModel>() {

    companion object {
        const val TAG = "CategoriesFragment"
        fun newInstance() = CategoriesFragment()
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var categoriesAdapter: CategoriesAdapter

    override fun provideLayoutId() = R.layout.categories_layout

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getCategories().observe(this, Observer {
            it?.run { categoriesAdapter.appendData(this) }
        })
    }

    override fun setupView(view: View) {
        rv_categories.layoutManager = linearLayoutManager
        rv_categories.adapter = categoriesAdapter
    }

}