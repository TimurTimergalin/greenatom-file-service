package com.tmtimergalin.greenatom_file_service.api.service.files;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Представление файла, с которым работает FileService
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileDto {
    private String title = null;
    private LocalDateTime creationDate = null;
    private String description = null;
    private String content = null;
}
