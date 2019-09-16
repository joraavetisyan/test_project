package com.testproject.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.testproject.data.repository.MainRepository
import com.testproject.ui.base.BaseFragment
import com.testproject.ui.categories.CategoriesAdapter
import com.testproject.ui.categories.CategoriesViewModel
import com.testproject.ui.products.ProductsAdapter
import com.testproject.ui.products.ProductsViewModel
import com.testproject.utils.ViewModelProviderFactory
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideCategoriesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        mainRepository: MainRepository
    ): CategoriesViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(CategoriesViewModel::class) {
                CategoriesViewModel(schedulerProvider, compositeDisposable, networkHelper, mainRepository)
            }
        ).get(CategoriesViewModel::class.java)

    @Provides
    fun provideProductsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        mainRepository: MainRepository
    ): ProductsViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(ProductsViewModel::class) {
                ProductsViewModel(schedulerProvider, compositeDisposable, networkHelper, mainRepository)
            }
        ).get(ProductsViewModel::class.java)

    @Provides
    fun provideCategoriesAdapter() = CategoriesAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun provideProductsAdapter() = ProductsAdapter(fragment.lifecycle, ArrayList())

}