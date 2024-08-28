package com.tmtimergalin.greenatom_file_service.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * ORM-сущность для файла
 */
@Table("files")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class File {
    @Id
    private Integer id = null;
    @Column
    private String title = null;
    @Column("creation_date")
    private LocalDateTime creationDate = null;
    @Column
    private String description = null;
    @Column
    private String content = null;
}
