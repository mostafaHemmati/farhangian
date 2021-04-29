package com.hemmati.farhangian.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.farhangian.domain.exeption.ApiError
import com.hemmati.farhangian.domain.model.category.CategoryData
import com.hemmati.farhangian.domain.model.category.CategoryModel
import com.hemmati.farhangian.domain.usecase.GetCategoryUseCase
import com.hemmati.farhangian.domain.usecase.base.UseCaseResponse

class DashboardViewModel constructor(
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {

    private val _submitFragmentList = MutableLiveData<List<CategoryData>>()
    val submitFragmentList: LiveData<List<CategoryData>> get() = _submitFragmentList

    private val _navigateToVideoList = MutableLiveData<Unit>()
    val navigateToVideoList:LiveData<Unit> get() = _navigateToVideoList

    private val _error = MutableLiveData<String>()
    val error:LiveData<String> get() = _error

    init {
        getCategories()
    }

    fun navigateToVideoList(){
        _navigateToVideoList.value = Unit
    }

    private fun getCategories() {
        getCategoryUseCase.invoke(viewModelScope, null, object : UseCaseResponse<CategoryModel> {
            override fun onSuccess(result: CategoryModel) {
                _submitFragmentList.value = result.data
            }

            override fun onError(apiError: ApiError?) {
                _error.value = apiError?.message
            }
        })
    }

}