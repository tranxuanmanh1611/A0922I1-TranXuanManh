package ghost_company.music_app.entity;

import javax.persistence.*;

@Table(name = "song_name")
@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="song_id")
    private int id;
    @Column(name="song_name")
    private String name;
    @Column(name="song_artist")
    private String artist;
    @Column(name = "song_gerne")
    private String gerne;
    @Column(name="song_link")
    private String link;

    public Music() {
    }

    public Music(String name, String artist, String gerne, String link) {
        this.name = name;
        this.artist = artist;
        this.gerne = gerne;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
