package com.testproject.data.repository

import com.testproject.data.model.Category
import com.testproject.data.model.Product
import com.testproject.data.remote.NetworkService
import com.testproject.data.remote.response.ResponseData
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainRepository @Inject constructor(private val networkService: NetworkService) {

    //fun getCategories(): Single<List<Category>> = networkService.getData().map { it.data }

    fun getCategories(): Single<List<Category>> {
        return Single.create { emitter ->
            var categoriesList = ArrayList<Category>()
            for (i in 1..10) {
                var productsList = ArrayList<Product>()
                var product = Product("name", i.toDouble())
                productsList.add(product)
                categoriesList.add(Category("tile $i", "desc $i", productsList))
            }
            emitter.onSuccess(categoriesList)
        }
    }
}
