package com.tmtimergalin.greenatom_file_service.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import com.tmtimergalin.greenatom_file_service.data.entity.File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Автоматически генерируемый преобразователь различных сущностей, представляющих файл
 */
@Mapper(componentModel = "spring")
public interface FileEntityToDtoMapper {
    FileDto convert(File file);

    @Mapping(target = "id", ignore = true)
    File convert(FileDto fileDto);
}
