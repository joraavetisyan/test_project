package com.testproject.ui.products

import androidx.lifecycle.LiveData
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

class ProductsItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Product>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "ProductsItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.name }
    val price: LiveData<Double?> = Transformations.map(data) { it.price }

    fun onItemClick(position: Int) {
        messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.name}"))
        Logger.d(TAG, "onItemClick at $position")
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}