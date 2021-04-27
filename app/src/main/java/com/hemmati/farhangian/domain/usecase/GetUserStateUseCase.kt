package com.hemmati.farhangian.domain.usecase

import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import com.hemmati.farhangian.domain.repository.SubCategoryRepository
import com.hemmati.farhangian.domain.usecase.base.UseCase


class GetUserStateUseCase constructor(private val subCategoryRepository: SubCategoryRepository) :
    UseCase<ActiveUserModel, Any?>() {
    override suspend fun run(params: Any?): ActiveUserModel {
        return subCategoryRepository.getUserState(params.toString())
    }
}