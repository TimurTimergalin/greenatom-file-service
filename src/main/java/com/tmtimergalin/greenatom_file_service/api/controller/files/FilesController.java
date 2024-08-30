package com.tmtimergalin.greenatom_file_service.api.controller.files;

import com.tmtimergalin.greenatom_file_service.api.controller.files.body.request.CreateFileRequestBody;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFileResponse;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFilesResponse;
import org.springframework.http.ResponseEntity;

/**
 * Интерфейс rest-controller-а для доступа к файлам
 */
public interface FilesController {
    /**
     * Метод создания нового файла
     *
     * @param body: информация о  файле
     * @return : id созданного файла
     */
    ResponseEntity<Integer> createFile(CreateFileRequestBody body);

    /**
     * Метод получения файла по его id
     *
     * @param id: идентификатор файла
     * @return : информация о файле
     */
    ResponseEntity<GetFileResponse> getFile(int id);

    /**
     * Метод получения всех доступных файлов
     *
     * @param pageNumber: параметр пагинации - номер страницы (по умолчанию 0)
     * @param pageSize:   параметр пагинации - размер страницы (по умолчанию 5)
     * @return : список сфайлами в указанной странице
     */
    ResponseEntity<GetFilesResponse> getFiles(int pageNumber, int pageSize);
}
