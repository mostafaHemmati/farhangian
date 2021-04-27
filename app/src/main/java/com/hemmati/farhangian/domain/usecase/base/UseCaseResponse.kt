package com.hemmati.coroutineskoinsampleproject.domain.usecase.base

import com.hemmati.farhangian.domain.exeption.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

