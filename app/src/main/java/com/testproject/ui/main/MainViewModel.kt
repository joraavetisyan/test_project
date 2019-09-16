package com.testproject.ui.main

import com.testproject.data.repository.MainRepository
import com.testproject.ui.base.BaseViewModel
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val mainRepository: MainRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
    }
}