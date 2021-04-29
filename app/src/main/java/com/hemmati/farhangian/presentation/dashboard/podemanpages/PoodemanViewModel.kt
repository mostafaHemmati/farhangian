package com.hemmati.farhangian.presentation.dashboard.podemanpages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.farhangian.domain.exeption.ApiError
import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import com.hemmati.farhangian.domain.usecase.GetSubCategoryUseCase
import com.hemmati.farhangian.domain.usecase.GetUserStateUseCase
import com.hemmati.farhangian.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class PoodemanViewModel(
    private val getSubCategoryUseCase: GetSubCategoryUseCase,
    private val getUserStateUseCase: GetUserStateUseCase
) : ViewModel() {
    val subCategoryData = MutableLiveData<SubCategoryModel>()
    val userStateData = MutableLiveData<ActiveUserModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun subCategorise(categoryId: String) {
        showProgressbar.value = true
        getSubCategoryUseCase.invoke(
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

    fun checkIsActiveUserOrNot(deviceId: String, isActive: () -> Unit, isNotActive: () -> Unit) {
        getUserStateUseCase.invoke(
            viewModelScope,
            deviceId,
            object : UseCaseResponse<ActiveUserModel> {
                override fun onSuccess(result: ActiveUserModel) {
                    if (result.data != null)
                        isActive.invoke()
                    else
                        isNotActive.invoke()
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.message
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