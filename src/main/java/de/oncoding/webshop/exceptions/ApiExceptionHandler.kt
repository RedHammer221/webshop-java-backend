package de.oncoding.webshop.exceptions


import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(Throwable::class)
    fun handleErrors(request: HttpServletRequest, exception: Throwable): ResponseEntity<ErrorInfo> {

        println(exception.message)
        println(exception)

        val (code, message) = when(exception) {
            is IdNotFoundException -> HttpStatus.BAD_REQUEST to exception.message
            is WebshopException -> exception.statusCode to exception.message
            is IllegalArgumentException -> HttpStatus.BAD_REQUEST to (exception.message ?: "Illegal Argument")
            else -> HttpStatus.INTERNAL_SERVER_ERROR to (exception.message ?: "An error occured")
        }

        val errorInfo = ErrorInfo(message , request.requestURI)
        return ResponseEntity(errorInfo, code)
    }
}

data class ErrorInfo(
    val error: String,
    val path: String
)