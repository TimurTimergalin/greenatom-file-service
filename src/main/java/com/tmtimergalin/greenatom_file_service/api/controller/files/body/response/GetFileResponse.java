package com.tmtimergalin.greenatom_file_service.api.controller.files.body.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Ответ для FilesController.getFile
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetFileResponse {
    private String title = null;
    private LocalDateTime creation_date = null;
    private String description = null;
    private String content = null;
}
