package com.tmtimergalin.greenatom_file_service.api.service.files.exceptions;


/**
 * Исключение, возникающее при поптыке добавления файла с существующим именем
 */
public class FileExistsException extends FileServiceException {
    public FileExistsException() {
    }

    public FileExistsException(String message) {
        super(message);
    }

    public FileExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExistsException(Throwable cause) {
        super(cause);
    }
}
