package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;

/**
 * Исключение, возникающее при попытке сохранения файла, содержимое которого не является base64-строкой
 */
public class InvalidFileContent extends FileServiceException {
    public InvalidFileContent() {
    }

    public InvalidFileContent(String message) {
        super(message);
    }

    public InvalidFileContent(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFileContent(Throwable cause) {
        super(cause);
    }
}
