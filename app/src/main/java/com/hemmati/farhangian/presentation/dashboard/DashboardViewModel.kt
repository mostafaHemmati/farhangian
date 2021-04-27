package com.hemmati.farhangian.presentation.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.coroutineskoinsampleproject.domain.usecase.base.UseCaseResponse
import com.hemmati.farhangian.domain.exeption.ApiError
import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import com.hemmati.farhangian.domain.usecase.GetCategoryUseCase
import com.hemmati.farhangian.domain.usecase.GetUserStateUseCase
import kotlinx.coroutines.cancel

class DashboardViewModel constructor(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getUserStateUseCase: GetUserStateUseCase
) : ViewModel() {
    val subCategoryData = MutableLiveData<SubCategoryModel>()
    val userStateData = MutableLiveData<ActiveUserModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()


    fun subCategorise(categoryId: String) {
        showProgressbar.value = true
        getCategoryUseCase.invoke(
            viewModelScope,
            categoryId,
            object : UseCaseResponse<SubCategoryModel> {
                override fun onSuccess(result: SubCategoryModel) {
                    subCategoryData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }

            })
    }

    fun getUserState(deviceId: String) {
        Log.d(Companion.TAG, "getUserState: $deviceId")
        getUserStateUseCase.invoke(
            viewModelScope,
            deviceId,
            object : UseCaseResponse<ActiveUserModel> {
                override fun onSuccess(result: ActiveUserModel) {
                    userStateData.value = result
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                }

            })
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private const val TAG = "DashboardViewModel"
    }
}