package gh.code.dictionary.core

open class AppException(
    message: String? = "",
    cause: Throwable? = null
) : Exception(message, cause)

class ConnectionException(
    cause: Exception
) : AppException(cause = cause)

class DataNotFoundException(
    message: String?
) : AppException(message = message)

class EmptyFieldException : AppException()

class ParseBackendException(
    cause: Throwable
) : AppException(cause = cause)
