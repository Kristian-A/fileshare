package org.homework.fileshare.Repositories;

import org.homework.fileshare.Entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    List<FileEntity> findAll();
    FileEntity findById(int id);
    List<FileEntity> findByParent(FileEntity parent);

    void deleteById(int id);
}
