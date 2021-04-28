package com.hemmati.farhangian.di

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.dataaccess.repository.GetUserStateRepository
import com.hemmati.farhangian.domain.dataaccess.repository.GetUserStateRepositoryImpl
import com.hemmati.farhangian.domain.dataaccess.repository.SubCategoryRepository
import com.hemmati.farhangian.domain.dataaccess.repository.SubCategoryRepositoryImpl
import com.hemmati.farhangian.domain.usecase.GetCategoryUseCase
import com.hemmati.farhangian.domain.usecase.GetUserStateUseCase
import com.hemmati.farhangian.presentation.dashboard.DashboardViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PoodemanModule = module {
    viewModel { DashboardViewModel(get(), get()) }
    single { createGetSubCategoryUseCase(get()) }
    single { createSubCategoryRepository(get()) }
    single { createGetUserStateUseCase(get()) }
    single { createGetUserStateRepository(get()) }
}

fun createSubCategoryRepository(apiService: ApiService): SubCategoryRepository {
    return SubCategoryRepositoryImpl(apiService)
}

fun createGetUserStateRepository(apiService: ApiService): GetUserStateRepository {
    return GetUserStateRepositoryImpl(apiService)
}

fun createGetSubCategoryUseCase(subCategoryRepository: SubCategoryRepository): GetCategoryUseCase {
    return GetCategoryUseCase(subCategoryRepository)
}

fun createGetUserStateUseCase(getUserStateRepository: GetUserStateRepository): GetUserStateUseCase {
    return GetUserStateUseCase(getUserStateRepository)
}