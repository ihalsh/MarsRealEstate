package com.example.android.marsrealestate.di

import com.example.android.marsrealestate.MarsRealEstateApplication
import com.example.android.marsrealestate.detail.DetailViewModel
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MarsRealEstateApplication() }
}

val viewModelModule = module {
    viewModel { (marsProperty: MarsProperty) -> DetailViewModel(marsProperty, get()) }
    viewModel { OverviewViewModel() }
}

