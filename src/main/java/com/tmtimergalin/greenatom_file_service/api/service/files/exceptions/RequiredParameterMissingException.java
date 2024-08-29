package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;

/**
 * Исключение, возникающее при попытке создания файла, не указывая обязательных параметров
 */
public class RequiredParameterMissingException extends FileServiceException {
    public RequiredParameterMissingException() {
    }

    public RequiredParameterMissingException(String message) {
        super(message);
    }

    public RequiredParameterMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequiredParameterMissingException(Throwable cause) {
        super(cause);
    }
}
