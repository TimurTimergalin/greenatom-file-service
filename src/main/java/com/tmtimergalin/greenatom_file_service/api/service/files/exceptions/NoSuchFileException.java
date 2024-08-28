package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;

/**
 * Исключение, возникающее при попытке получения файла по несуществующему идентификатору
 */
public class NoSuchFileException extends FileServiceException {
    public NoSuchFileException() {
    }

    public NoSuchFileException(String message) {
        super(message);
    }

    public NoSuchFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchFileException(Throwable cause) {
        super(cause);
    }
}
