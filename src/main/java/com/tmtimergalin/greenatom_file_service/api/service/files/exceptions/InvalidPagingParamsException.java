package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;

/**
 * Исключение, возникающее при попытке получения списака файлов с неправильными настройками страници
 */
public class InvalidPagingParamsException extends FileServiceException {
    public InvalidPagingParamsException() {
    }

    public InvalidPagingParamsException(String message) {
        super(message);
    }

    public InvalidPagingParamsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPagingParamsException(Throwable cause) {
        super(cause);
    }
}
