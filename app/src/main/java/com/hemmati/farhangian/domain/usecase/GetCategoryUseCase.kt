package com.hemmati.farhangian.domain.usecase

import com.hemmati.farhangian.domain.dataaccess.repository.GetCategoryRepository
import com.hemmati.farhangian.domain.model.category.CategoryModel
import com.hemmati.farhangian.domain.usecase.base.UseCase

class GetCategoryUseCase(
    private val repository: GetCategoryRepository
) : UseCase<CategoryModel, Any?>() {
    override suspend fun run(params: Any?): CategoryModel {
        return repository.getCategory()
    }
}