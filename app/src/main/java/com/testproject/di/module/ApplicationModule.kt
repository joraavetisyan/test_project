package com.testproject.di.module

import android.app.Application
import android.content.Context
import com.testproject.di.ApplicationContext
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.RxSchedulerProvider
import com.testproject.utils.rx.SchedulerProvider
import com.testproject.BuildConfig
import com.testproject.TestApp
import com.testproject.data.remote.NetworkService
import com.testproject.data.remote.Networking
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: TestApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}