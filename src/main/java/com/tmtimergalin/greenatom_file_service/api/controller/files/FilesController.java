package com.tmtimergalin.greenatom_file_service.api.controller.files;

import com.tmtimergalin.greenatom_file_service.api.controller.files.body.request.CreateFileRequestBody;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFileResponse;
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
}
