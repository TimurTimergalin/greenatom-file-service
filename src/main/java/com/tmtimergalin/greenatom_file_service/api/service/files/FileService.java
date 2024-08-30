package com.tmtimergalin.greenatom_file_service.api.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.*;

import java.util.List;

/**
 * Интерфейс сервиса для работы с файлами
 */
public interface FileService {
    /**
     * Создает файл в базе данных
     *
     * @param file: Файл, который нужно добавить
     * @return : Id добавленного фалйа
     * @throws RequiredParameterMissingException: В переданном файле отсутствуют обязательные параметры
     * @throws FileExistsException:               Передан файл с существующим названием
     * @throws InvalidFileContent:                Содержимое переданного файла не закодированно с помощью base64
     */
    int createFile(FileDto file) throws RequiredParameterMissingException, FileExistsException, InvalidFileContent;

    /**
     * Выдает файл из базы данных по его id
     *
     * @param id: id файла
     * @return : Искомый файл
     * @throws NoSuchFileException: Файл не найден
     */
    FileDto getFile(int id) throws NoSuchFileException;

    /**
     * Возвращает список всех файлов на указанной странице
     *
     * @param pageNumber: Номер страницы
     * @param pageSize:   Размер страницы
     * @return : Список файлов
     * @throws InvalidPagingParamsException: pageNumber < 0 или pageSize < 1
     */
    List<FileDto> getAllFiles(int pageNumber, int pageSize) throws InvalidPagingParamsException;
}
