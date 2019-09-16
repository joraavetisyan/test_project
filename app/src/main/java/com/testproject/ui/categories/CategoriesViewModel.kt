package com.testproject.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.testproject.data.model.Category
import com.testproject.data.repository.MainRepository
import com.testproject.ui.base.BaseViewModel
import com.testproject.utils.Resource
import com.testproject.utils.network.NetworkHelper
import com.testproject.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class CategoriesViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val mainRepository: MainRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "CategoriesViewModel"
    }

    private val categoriesLiveData: MutableLiveData<Resource<List<Category>>> = MutableLiveData()

    fun getCategories(): LiveData<List<Category>> =
        Transformations.map(categoriesLiveData) { it.data }

    override fun onCreate() {
        if (categoriesLiveData.value == null && checkInternetConnectionWithMessage()) {
            categoriesLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                mainRepository.getCategories()
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { categoriesLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            categoriesLiveData.postValue(Resource.error())
                        })
            )
        }
    }

}