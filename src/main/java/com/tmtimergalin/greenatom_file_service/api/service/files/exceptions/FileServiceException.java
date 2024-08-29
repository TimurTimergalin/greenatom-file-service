package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;

/**
 * Базовое исключение для сервиса файлов
 */
public class FileServiceException extends Exception {
    public FileServiceException() {
    }

    public FileServiceException(String message) {
        super(message);
    }

    public FileServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileServiceException(Throwable cause) {
        super(cause);
    }
}
