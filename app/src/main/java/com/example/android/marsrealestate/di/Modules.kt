package com.example.android.marsrealestate.di

import com.example.android.marsrealestate.MarsRealEstateApplication
import com.example.android.marsrealestate.detail.DetailViewModel
import com.example.android.marsrealestate.network.MarsApiService
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.OverviewViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofitModule = module {

    factory<Moshi> {
        Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    single<MarsApiService> {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build()
                .create(MarsApiService::class.java)
    }
}

val viewModelModule = module {
    viewModel { (marsProperty: MarsProperty, application : MarsRealEstateApplication) ->
        DetailViewModel(marsProperty, application)
    }
    viewModel { OverviewViewModel() }
}

private const val BASE_URL = "https://mars.udacity.com/"