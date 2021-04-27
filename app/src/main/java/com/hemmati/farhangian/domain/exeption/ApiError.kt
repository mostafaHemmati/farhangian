package com.hemmati.farhangian.domain.exeption


private const val BAD_REQUEST_ERROR_MESSAGE = "Bad Request!"
private const val FORBIDDEN_ERROR_MESSAGE = "Forbidden!"
private const val NOT_FOUND_ERROR_MESSAGE = "Not Found!"
private const val METHOD_NOT_ALLOWED_ERROR_MESSAGE = "Method Not Allowed!"
private const val CONFLICT_ERROR_MESSAGE = "Conflict!"
private const val UNAUTHORIZED_ERROR_MESSAGE = "Unauthorized!"
private const val INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server error!"
private const val NO_CONNECTION_ERROR_MESSAGE = "No Connection!"
private const val TIMEOUT_ERROR_MESSAGE = "Time Out!"
const val UNKNOWN_ERROR_MESSAGE = "Unknown Error!"

data class ApiError(val message: String?, val code: Int?, var errorStatus: ErrorStatus) {

    constructor(message: String?, errorStatus: ErrorStatus) : this(message, null, errorStatus)

    fun getErrorMessage(): String {
        return when (errorStatus) {
            ErrorStatus.BAD_REQUEST -> BAD_REQUEST_ERROR_MESSAGE
            ErrorStatus.FORBIDDEN -> FORBIDDEN_ERROR_MESSAGE
            ErrorStatus.NOT_FOUND -> NOT_FOUND_ERROR_MESSAGE
            ErrorStatus.METHOD_NOT_ALLOWED -> METHOD_NOT_ALLOWED_ERROR_MESSAGE
            ErrorStatus.CONFLICT -> CONFLICT_ERROR_MESSAGE
            ErrorStatus.UNAUTHORIZED -> UNAUTHORIZED_ERROR_MESSAGE
            ErrorStatus.INTERNAL_SERVER_ERROR -> INTERNAL_SERVER_ERROR_MESSAGE
            ErrorStatus.NO_CONNECTION -> NO_CONNECTION_ERROR_MESSAGE
            ErrorStatus.TIMEOUT -> TIMEOUT_ERROR_MESSAGE
            ErrorStatus.UNKNOWN_ERROR -> UNKNOWN_ERROR_MESSAGE
        }
    }


    enum class ErrorStatus {
        BAD_REQUEST,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        METHOD_NOT_ALLOWED,
        CONFLICT,
        INTERNAL_SERVER_ERROR,
        TIMEOUT,
        NO_CONNECTION,
        UNKNOWN_ERROR
    }
}