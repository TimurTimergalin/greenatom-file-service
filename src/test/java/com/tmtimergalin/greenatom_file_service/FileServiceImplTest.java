package com.tmtimergalin.greenatom_file_service;

import com.tmtimergalin.greenatom_file_service.api.service.files.FileDto;
import com.tmtimergalin.greenatom_file_service.api.service.files.exceptions.*;
import com.tmtimergalin.greenatom_file_service.data.repo.FileRepo;
import com.tmtimergalin.greenatom_file_service.service.files.FileEntityToDtoMapperImpl;
import com.tmtimergalin.greenatom_file_service.service.files.FileServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@ExtendWith(MockitoExtension.class)
public class FileServiceImplTest {
    @Mock
    FileRepo fileRepo;

    FileEntityToDtoMapperImpl mapper = new FileEntityToDtoMapperImpl();

    @Test
    public void testMissingRequiredParams() {
        FileServiceImpl fileServiceImpl = new FileServiceImpl(fileRepo, mapper);
        FileDto[] fileDtos = new FileDto[]{
                new FileDto(null, null, null, ""),
                new FileDto("", null, null, ""),
                new FileDto("ProperTitle", null, null, ""),
                new FileDto("ProperTitle", LocalDateTime.now(), null, null)
        };

        for (FileDto fileDto : fileDtos) {
            assertThrowsExactly(RequiredParameterMissingException.class, () -> fileServiceImpl.createFile(fileDto));
        }
    }

    @Test
    public void testBase64Validation() {
        FileServiceImpl fileServiceImpl = new FileServiceImpl(fileRepo, mapper);
        FileDto[] fileDtos = new FileDto[]{
                new FileDto("ProperTitle", LocalDateTime.now(), null, "кириллица"),
                new FileDto("ProperTitle", LocalDateTime.now(), null, "~~~")
        };

        for (FileDto fileDto : fileDtos) {
            assertThrowsExactly(InvalidFileContent.class, () -> fileServiceImpl.createFile(fileDto));
        }
    }

    @Test
    public void testTitleUniqueConstraint() {
        FileServiceImpl fileServiceImpl = new FileServiceImpl(fileRepo, mapper);
        FileDto dto = new FileDto("ProperTitle", LocalDateTime.now(), null, "");

        Mockito.when(fileRepo.save(Mockito.any())).thenThrow(DbActionExecutionException.class); // Предполагаем, что условие уникальности нарушено
        assertThrows(FileExistsException.class, () -> fileServiceImpl.createFile(dto));
    }

    @Test
    public void testUnknownFile() {
        FileServiceImpl fileServiceImpl = new FileServiceImpl(fileRepo, mapper);
        Mockito.when(fileRepo.findById(Mockito.any())).thenReturn(Optional.empty());
        assertThrows(NoSuchFileException.class, () -> fileServiceImpl.getFile(1));
    }

    @Test
    public void testInvalidPagingParams() {
        FileServiceImpl fileServiceImpl = new FileServiceImpl(fileRepo, mapper);
        int[][] invalidPagingParams = new int[][]{
                {0, 0},
                {-1, 1},
                {-1, 0}
        };
        for (int[] invalidPagingParam : invalidPagingParams) {
            assertThrowsExactly(InvalidPagingParamsException.class, () -> fileServiceImpl.getAllFiles(invalidPagingParam[0], invalidPagingParam[1]));
        }
    }
}
