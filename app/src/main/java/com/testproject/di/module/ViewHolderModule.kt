package com.testproject.di.module

import androidx.lifecycle.LifecycleRegistry
import com.testproject.di.ViewModelScope
import com.testproject.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}