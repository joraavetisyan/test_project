package com.testproject.di.component

import android.app.Application
import android.content.Context
import com.testproject.di.ApplicationContext
import com.testproject.di.module.ApplicationModule
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import com.testproject.TestApp
import com.testproject.data.remote.NetworkService
import com.testproject.data.repository.MainRepository
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: TestApp)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getMainRepository(): MainRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}