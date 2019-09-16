package com.testproject.di.component

import com.testproject.di.FragmentScope
import com.testproject.di.module.FragmentModule
import com.testproject.ui.categories.CategoriesFragment
import com.testproject.ui.products.ProductsFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: CategoriesFragment)

    fun inject(fragment: ProductsFragment)
}