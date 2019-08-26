package com.poudelSpring.songr.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Album {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    String title;
    String artist;
    int songCount;
    long length;
    String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    List<Song> songs;

    public Album() {}


    public Album(String title, String artist, int songCount, long length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }
    public Album(String album) {
        this.title = album;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public long getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public List<Song> getSongs() {
        return songs;
    }

    public String toString(){
        return String.format("%s %s %d %d %s",
                this.title, this.artist, this.songCount, this.length, this.imageUrl);
    }
}
