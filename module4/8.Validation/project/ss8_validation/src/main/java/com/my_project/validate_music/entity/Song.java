package com.my_project.validate_music.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "song_name")
    @NotBlank(message = "Không được để trống")
    @Size(max = 800)
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa kí tự đặc biệt")
    private String name;

    @Column(name = "song_singer")
    @NotBlank(message = "Không được để trống")
    @Size(max = 300)
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa kí tự đặc biệt")
    private String singer;

    @Column(name = "song_genre")
    @NotBlank(message = "Không được để trống")
    @Size(max = 1000)
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Không chứa kí tự đặc biệt")
    private String genre;

    public Song() {
    }

    public Song(String name, String singer, String genre) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
