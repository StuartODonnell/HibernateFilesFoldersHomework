package com.codeclan.example.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "folders")


public class Folder {


    private int id;
    private String folderTitle;
    private Set<File> files;

    public Folder(){


    }

    public Folder(int id, String folderTitle) {
        this.id = id;
        this.folderTitle = folderTitle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Column(name="folder_title")
    public String getFolderTitle() {
        return folderTitle;
    }

    public void setFolderTitle(String folderTitle) {
        this.folderTitle = folderTitle;
    }

@OneToMany(mappedBy = "folder")
    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }
}