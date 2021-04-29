package com.hemmati.farhangian.domain.usecase

import com.hemmati.farhangian.domain.dataaccess.repository.GetUserStateRepository
import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.usecase.base.UseCase


class GetUserStateUseCase constructor(
    private val getActiveUserRepository: GetUserStateRepository
) : UseCase<ActiveUserModel, Any?>() {
    override suspend fun run(params: Any?): ActiveUserModel {
        return getActiveUserRepository.getUserState(params.toString())
    }
}