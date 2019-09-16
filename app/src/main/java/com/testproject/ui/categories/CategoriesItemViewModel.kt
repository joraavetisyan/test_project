package com.testproject.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.testproject.data.model.Category
import com.testproject.data.model.Product
import com.testproject.ui.base.BaseItemViewModel
import com.testproject.utils.Resource
import com.testproject.utils.log.Logger
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoriesItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Category>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "CategoriesItemViewModel"
    }

    val productsFragmentLiveData: MutableLiveData<List<Product>> = MutableLiveData()

    val title: LiveData<String> = Transformations.map(data) { it.title }
    val description: LiveData<String?> = Transformations.map(data) { it.description }

    fun onItemClick(position: Int) {
        messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.title}"))
        Logger.d(TAG, "onItemClick at $position")
        productsFragmentLiveData.postValue(data.value?.products)
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}