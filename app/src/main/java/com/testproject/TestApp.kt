package com.testproject

import android.app.Application
import com.testproject.di.component.ApplicationComponent
import com.testproject.di.component.DaggerApplicationComponent
import com.testproject.di.module.ApplicationModule

class TestApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}