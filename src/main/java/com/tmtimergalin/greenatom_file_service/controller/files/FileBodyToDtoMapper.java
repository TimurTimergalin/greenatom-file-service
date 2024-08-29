package com.tmtimergalin.greenatom_file_service.controller.files;

import com.tmtimergalin.greenatom_file_service.api.controller.files.body.request.CreateFileRequestBody;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFileResponse;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Автоматически генерируемый преобразователь различных сущностей, представляющих файл
 */
@Mapper(componentModel = "spring")
public interface FileBodyToDtoMapper {
    @Mapping(target = "creationDate", source = "creation_date")
    FileDto convert(CreateFileRequestBody requestBody);

    @Mapping(target = "creation_date", source = "creationDate")
    GetFileResponse convert(FileDto fileDto);
}
