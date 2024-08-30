package com.tmtimergalin.greenatom_file_service.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileService;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.*;
import com.tmtimergalin.greenatom_file_service.data.entity.File;
import com.tmtimergalin.greenatom_file_service.data.repo.FileRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepo fileRepo;
    private final FileEntityToDtoMapper fileMapper;

    private boolean checkFileDtoValidity(FileDto file) { // Проверяет, что все обязательные поля на месте
        return file.getTitle() != null && !file.getTitle().isEmpty() && file.getContent() != null && file.getCreationDate() != null;
    }

    @Override
    public int createFile(FileDto file) throws RequiredParameterMissingException, FileExistsException, InvalidFileContent {
        if (!checkFileDtoValidity(file)) {
            throw new RequiredParameterMissingException("Required parameters missing");
        }

        if (!Base64.isBase64(file.getContent())) {
            throw new InvalidFileContent("File content is not base64-encoded");
        }
        try {
            File toAdd = fileMapper.convert(file);
            return fileRepo.save(toAdd).getId();
        } catch (DbActionExecutionException e) {
            throw new FileExistsException("File with such name already exists");
        }
    }

    @Override
    public FileDto getFile(int id) throws NoSuchFileException {
        Optional<File> file = fileRepo.findById(id);
        if (file.isPresent()) {
            return fileMapper.convert(file.get());
        }

        throw new NoSuchFileException("File with such id does not exist");
    }

    @Override
    public List<FileDto> getAllFiles(int pageNumber, int pageSize) throws InvalidPagingParamsException {
        Sort creationDateSort = Sort.by("creationDate").descending();
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize, creationDateSort);
            return fileRepo.findAll(pageable).getContent().stream().map(fileMapper::convert).toList();
        } catch (IllegalArgumentException ignore) {
            throw new InvalidPagingParamsException("Invalid page number or size");
        }
    }
}
