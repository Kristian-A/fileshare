package org.homework.fileshare.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private FileEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.REMOVE)
    private Set<FileEntity> children;
    private int depth;

    public FileEntity(String name) {
        this.name = name;
        depth = 0;
    }

    public FileEntity() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public FileEntity getParent() { return parent; }
    public void setParent(FileEntity parent) { this.parent = parent; }

    public String getSpacing() {
        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "____";
        }
        return tabs;
    }

    public int getDepth() { return depth; }
    public void setDepth(int depth) { this.depth = depth; }

    public Set<FileEntity> getChildren() { return children; }

    public void addChild(FileEntity child) {
        children.add(child);
        child.setParent(this);
        child.setDepth(depth+1);
    }
}
