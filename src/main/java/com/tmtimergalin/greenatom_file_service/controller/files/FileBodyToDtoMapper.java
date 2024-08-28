package com.tmtimergalin.greenatom_file_service.controller.files;

import com.tmtimergalin.greenatom_file_service.api.controller.files.body.request.CreateFileRequestBody;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFileResponse;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import org.mapstruct.Mapper;

/**
 * Автоматически генерируемый преобразователь различных сущностей, представляющих файл
 */
@Mapper(componentModel = "spring")
public interface FileBodyToDtoMapper {
    FileDto convert(CreateFileRequestBody requestBody);

    GetFileResponse convert(FileDto fileDto);
}
