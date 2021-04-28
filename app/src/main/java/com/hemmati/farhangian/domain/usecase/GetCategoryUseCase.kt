package com.hemmati.farhangian.domain.usecase

import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import com.hemmati.farhangian.domain.dataaccess.repository.SubCategoryRepository
import com.hemmati.farhangian.domain.usecase.base.UseCase


class GetCategoryUseCase constructor(
    private val subCategoryRepository: SubCategoryRepository
    ) : UseCase<SubCategoryModel, Any?>() {
    override suspend fun run(params: Any?): SubCategoryModel {
        return subCategoryRepository.getSubCategory(params.toString())
    }
}