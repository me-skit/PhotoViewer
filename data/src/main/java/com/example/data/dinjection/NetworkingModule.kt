package com.example.data.dinjection

import com.example.data.BuildConfig
import com.example.data.networking.service.RetrofitPhotoService
import com.example.data.repository.datasourceinterface.PhotoRemoteDatasource
import com.example.data.repository.implementation.PhotoRemoteDatasourceImpl
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkingModule = module {
    single { GsonConverterFactory.create() as Converter.Factory }

    single {
        Retrofit.Builder()
            .addConverterFactory(get())
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(RetrofitPhotoService::class.java) }

    single<PhotoRemoteDatasource> { PhotoRemoteDatasourceImpl(get()) }
}