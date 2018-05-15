package com.codeclan.example.models;

import javax.persistence.*;

@Entity
@Table(name = "files")


public class File {

    private int id;
    private String fileName;
    private String fileExtension;
    private int size;
    private Folder folder;

    public File() {
    }

    public File(int id, String fileName, String fileExtension, int size, Folder folder) {
        this.id = id;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.size = size;
        this.folder = folder;
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
    @Column(name="file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Column(name="file_extension")
    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    @Column(name="size")
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @ManyToOne
    @JoinColumn(name="folder_id", nullable = false)
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
