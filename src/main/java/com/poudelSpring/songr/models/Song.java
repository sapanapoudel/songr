package com.poudelSpring.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    long length;
    int trackNumber;

    @ManyToOne
    Album album;

    public Song() {}

    public Song(String title, long length, int trackNumber) {

        this.title  = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public long getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

}
