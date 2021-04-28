package com.hemmati.farhangian.domain.dataaccess.repository

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.model.activation.ActiveUserModel

interface GetUserStateRepository {
    suspend fun getUserState(deviceId: String): ActiveUserModel
}

class GetUserStateRepositoryImpl(private val apiService: ApiService) : GetUserStateRepository {
    override suspend fun getUserState(deviceId: String): ActiveUserModel {
        return apiService.isActiveUser(deviceId)
    }
}