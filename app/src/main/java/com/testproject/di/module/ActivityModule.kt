package com.testproject.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.testproject.data.repository.MainRepository
import com.testproject.ui.base.BaseActivity
import com.testproject.ui.main.MainViewModel
import com.testproject.utils.ViewModelProviderFactory
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        mainRepository: MainRepository
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper, mainRepository)
        }).get(MainViewModel::class.java)
}