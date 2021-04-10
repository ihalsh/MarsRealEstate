package com.example.android.marsrealestate.di

import com.example.android.marsrealestate.MarsRealEstateApplication
import com.example.android.marsrealestate.detail.DetailViewModel
import com.example.android.marsrealestate.network.MarsApiService
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

val retrofitModule = module {
    single<MarsApiService> {
        Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MarsApiService::class.java)
    }
}

val appModule = module {
    single { MarsRealEstateApplication() }
}

val viewModelModule = module {
    viewModel { (marsProperty: MarsProperty) -> DetailViewModel(marsProperty, get()) }
    viewModel { OverviewViewModel() }
}

private const val BASE_URL = "https://mars.udacity.com/"