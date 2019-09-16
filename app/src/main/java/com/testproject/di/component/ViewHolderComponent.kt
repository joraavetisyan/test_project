package com.testproject.di.component

import com.testproject.di.ViewModelScope
import com.testproject.di.module.ViewHolderModule
import com.testproject.ui.categories.CategoriesItemViewHolder
import com.testproject.ui.products.ProductsItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: CategoriesItemViewHolder)

    fun inject(viewHolder: ProductsItemViewHolder)
}