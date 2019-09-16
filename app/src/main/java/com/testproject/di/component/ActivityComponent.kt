package com.testproject.di.component

import com.testproject.di.ActivityScope
import com.testproject.di.module.ActivityModule
import com.testproject.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}