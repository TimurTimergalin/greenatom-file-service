package com.tmtimergalin.greenatom_file_service.api.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.FileExistsException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.InvalidFileContent;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.NoSuchFileException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.RequiredParameterMissingException;

/**
 * Интерфейс сервиса для работы с файлами
 */
public interface FileService {
    int createFile(FileDto file) throws RequiredParameterMissingException, FileExistsException, InvalidFileContent;

    FileDto getFile(int id) throws NoSuchFileException;
}
