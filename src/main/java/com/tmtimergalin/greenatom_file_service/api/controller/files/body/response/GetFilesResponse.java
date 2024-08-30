package com.tmtimergalin.greenatom_file_service.api.controller.files.body.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Ответ для FilesController.getFiles
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetFilesResponse {
    private List<GetFileResponse> files = new ArrayList<>();
}
