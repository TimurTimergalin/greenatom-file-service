package com.tmtimergalin.greenatom_file_service.controller.files;

import com.tmtimergalin.greenatom_file_service.api.controller.files.FilesController;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.request.CreateFileRequestBody;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFileResponse;
import com.tmtimergalin.greenatom_file_service.api.controller.files.body.response.GetFilesResponse;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileService;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.FileServiceException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.InvalidPagingParamsException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.NoSuchFileException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilesControllerImpl implements FilesController {
    private final FileService fileService;
    private final FileBodyToDtoMapper fileMapper;

    @PostMapping("/file")
    @Override
    public ResponseEntity<Integer> createFile(@RequestBody CreateFileRequestBody body) {
        try {
            int fileId = fileService.createFile(
                    fileMapper.convert(body)
            );
            return ResponseEntity.ok(fileId);
        } catch (FileServiceException e) {  // В данном случае все исключения обрабатываются одинаково
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @GetMapping("/file/{id}")
    @Override
    public ResponseEntity<GetFileResponse> getFile(@PathVariable int id) {
        try {
            FileDto file = fileService.getFile(id);
            GetFileResponse response = fileMapper.convert(file);
            return ResponseEntity.ok(response);
        } catch (NoSuchFileException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping("/files")
    @Override
    public ResponseEntity<GetFilesResponse> getFiles(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize) {
        try {
            List<FileDto> files = fileService.getAllFiles(pageNumber, pageSize);
            GetFilesResponse response = new GetFilesResponse(
                    files.stream().map(fileMapper::convert).toList()
            );
            return ResponseEntity.ok(response);
        } catch (InvalidPagingParamsException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }
}
