package org.homework.fileshare.Repositories;

import org.homework.fileshare.Entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {}
