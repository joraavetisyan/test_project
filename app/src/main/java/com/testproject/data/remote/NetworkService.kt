package com.testproject.data.remote

import com.testproject.data.remote.response.ResponseData
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.CATEGORIES)
    fun getData(): Single<ResponseData>
}