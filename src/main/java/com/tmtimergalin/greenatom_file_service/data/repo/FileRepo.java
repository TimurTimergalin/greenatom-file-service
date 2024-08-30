package com.tmtimergalin.greenatom_file_service.data.repo;

import com.tmtimergalin.greenatom_file_service.data.entity.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс автоматически генерируемого класса для доступа к базе данных
 */
@Repository
public interface FileRepo extends CrudRepository<File, Integer> {
    Page<File> findAll(Pageable pageable);
}
