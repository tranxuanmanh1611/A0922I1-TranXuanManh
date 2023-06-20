package ghost_company.music_app.entity;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;

    private String name;

    private String artist;

    private String gerne;

    MultipartFile fileSong;

    public MusicForm() {
    }

    public MusicForm(String name, String artist, String gerne, MultipartFile fileSong) {
        this.name = name;
        this.artist = artist;
        this.gerne = gerne;
        this.fileSong = fileSong;
    }
    //for update form
    public MusicForm(int id,String name, String artist, String gerne) {
        this.id=id;
        this.name = name;
        this.artist = artist;
        this.gerne = gerne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGerne() {
        return gerne;
    }

    public void setGerne(String gerne) {
        this.gerne = gerne;
    }

    public MultipartFile getFileSong() {
        return fileSong;
    }

    public void setFileSong(MultipartFile fileSong) {
        this.fileSong = fileSong;
    }
}
