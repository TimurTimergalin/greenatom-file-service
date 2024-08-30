package com.tmtimergalin.greenatom_file_service.api.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.*;

import java.util.List;

/**
 * Интерфейс сервиса для работы с файлами
 */
public interface FileService {
    int createFile(FileDto file) throws RequiredParameterMissingException, FileExistsException, InvalidFileContent;

    FileDto getFile(int id) throws NoSuchFileException;

    List<FileDto> getAllFiles(int pageNumber, int pageSize) throws InvalidPagingParamsException;
}
