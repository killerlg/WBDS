package model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Long id;
    private String name;
    private String singer;
    private String type;
    private MultipartFile file;

    public SongForm() {
    }

    public SongForm(Long id, String name, String singer, String type, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}