package org.homework.fileshare.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "files")
public class FileEntity {

    @Id
    public int id;

    @Column(name = "name")
    public String name;
}
