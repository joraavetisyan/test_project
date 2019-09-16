package com.testproject.ui.main

import android.os.Bundle
import com.testproject.R
import com.testproject.data.model.Product
import com.testproject.di.component.ActivityComponent
import com.testproject.ui.base.BaseActivity
import com.testproject.ui.categories.CategoriesFragment
import com.testproject.ui.products.ProductsFragment

class MainActivity : BaseActivity<MainViewModel>() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        addCategoriesFragment()
    }

    private fun addCategoriesFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragment,
                CategoriesFragment.newInstance(),
                CategoriesFragment.TAG
            )
            .commit()
    }

    fun showProductsFragment(list: ArrayList<Product>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment,
                ProductsFragment.newInstance(list),
                CategoriesFragment.TAG
            )
            .commit()
    }
}