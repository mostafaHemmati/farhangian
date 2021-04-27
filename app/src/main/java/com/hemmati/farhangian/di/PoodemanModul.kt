package com.hemmati.farhangian.di

import com.hemmati.farhangian.data.repository.SubCategoryRepositoryImp
import com.hemmati.farhangian.data.source.remot.ApiService
import com.hemmati.farhangian.domain.repository.SubCategoryRepository
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
}


fun createSubCategoryRepository(apiService: ApiService): SubCategoryRepository {
    return SubCategoryRepositoryImp(apiService)
}

fun createGetSubCategoryUseCase(subCategoryRepository: SubCategoryRepository): GetCategoryUseCase {
    return GetCategoryUseCase(subCategoryRepository)
}

fun createGetUserStateUseCase(subCategoryRepository: SubCategoryRepository): GetUserStateUseCase {
    return GetUserStateUseCase(subCategoryRepository)
}