package com.tmtimergalin.greenatom_file_service.api.controller.files.body.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Тело запроса для FilesController.createFile
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateFileRequestBody {
    private String title = null;
    private LocalDateTime creationDate = null;
    private String description = null;
    private String content = null;
}
