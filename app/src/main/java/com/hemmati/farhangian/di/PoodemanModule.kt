package com.hemmati.farhangian.di

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.dataaccess.repository.*
import com.hemmati.farhangian.domain.usecase.GetCategoryUseCase
import com.hemmati.farhangian.domain.usecase.GetSubCategoryUseCase
import com.hemmati.farhangian.domain.usecase.GetUserStateUseCase
import com.hemmati.farhangian.domain.usecase.GetVideoListUseCase
import com.hemmati.farhangian.presentation.dashboard.DashboardViewModel
import com.hemmati.farhangian.presentation.dashboard.podemanpages.PoodemanViewModel
import com.hemmati.farhangian.presentation.videolist.VideoListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val PoodemanModule = module {
    //viewModel
    viewModel { DashboardViewModel(getCategoryUseCase = get()) }
    viewModel { PoodemanViewModel(getSubCategoryUseCase = get(), getUserStateUseCase = get()) }
    viewModel { (subCategoryId: String) ->
        VideoListViewModel(getVideoListUseCase = get(), subCategoryId = subCategoryId)
    }

    //repositories
    single { createSubCategoryRepository(apiService = get()) } bind SubCategoryRepository::class
    single { createCategoryRepository(apiService = get()) } bind GetCategoryRepository::class
    single { createGetUserStateRepository(apiService = get()) } bind GetUserStateRepository::class
    single { createGetVideoListRepository(apiService = get()) } bind GetVideoListRepository::class

    //useCases
    single { createCategoryUseCase(getCategoryRepository = get()) }
    single { createGetSubCategoryUseCase(subCategoryRepository = get()) }
    single { createGetUserStateUseCase(getUserStateRepository = get()) }
    single { createVideoListUseCase(getVideoListRepository = get()) }
}

fun createCategoryRepository(apiService: ApiService): GetCategoryRepository {
    return GetCategoryRepositoryImpl(apiService)
}

fun createSubCategoryRepository(apiService: ApiService): SubCategoryRepository {
    return SubCategoryRepositoryImpl(apiService)
}

fun createGetUserStateRepository(apiService: ApiService): GetUserStateRepository {
    return GetUserStateRepositoryImpl(apiService)
}

fun createGetVideoListRepository(apiService: ApiService): GetVideoListRepository {
    return GetVideoListRepositoryImpl(apiService)
}

fun createCategoryUseCase(getCategoryRepository: GetCategoryRepository): GetCategoryUseCase {
    return GetCategoryUseCase(getCategoryRepository)
}

fun createGetSubCategoryUseCase(subCategoryRepository: SubCategoryRepository): GetSubCategoryUseCase {
    return GetSubCategoryUseCase(subCategoryRepository)
}

fun createGetUserStateUseCase(getUserStateRepository: GetUserStateRepository): GetUserStateUseCase {
    return GetUserStateUseCase(getUserStateRepository)
}

fun createVideoListUseCase(getVideoListRepository: GetVideoListRepository): GetVideoListUseCase {
    return GetVideoListUseCase(getVideoListRepository)
}