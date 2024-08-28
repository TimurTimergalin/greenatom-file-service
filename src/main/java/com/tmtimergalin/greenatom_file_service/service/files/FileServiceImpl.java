package com.tmtimergalin.greenatom_file_service.service.files;

import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import com.tmtimergalin.greenatom_file_service.api.service.files.FileService;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.FileExistsException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.NoSuchFileException;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.RequiredParameterMissingException;
import com.tmtimergalin.greenatom_file_service.data.entity.File;
import com.tmtimergalin.greenatom_file_service.data.repo.FileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepo fileRepo;
    private final FileEntityToDtoMapper fileMapper;

    private boolean checkFileDtoValidity(FileDto file) { // Проверяет, что все обязательные поля на месте
        return file.getTitle() != null && !file.getTitle().isEmpty() && file.getContent() != null;
    }

    @Override
    public int createFile(FileDto file) throws RequiredParameterMissingException, FileExistsException {
        if (!checkFileDtoValidity(file)) {
            throw new RequiredParameterMissingException("Required parameters missing");
        }
        try {
            File toAdd = fileMapper.convert(file);
            return fileRepo.save(toAdd).getId();
        } catch (DataAccessException e) { // TODO: заменить на более специфичное исключение
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
}
