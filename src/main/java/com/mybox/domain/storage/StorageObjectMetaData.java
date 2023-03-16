package com.mybox.domain.storage;

import com.mybox.domain.common.BaseTimeEntity;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Entity
public class StorageObjectMetaData extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private StorageObjectType type;
    private String extension;
    private Long size;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "namespace_id")
    private Namespace namespace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private StorageObjectMetaData parentDirectory;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

}
