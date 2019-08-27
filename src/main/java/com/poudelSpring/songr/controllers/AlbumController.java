package com.poudelSpring.songr.controllers;


import com.poudelSpring.songr.models.Album;
import com.poudelSpring.songr.models.AlbumRepository;
import com.poudelSpring.songr.models.Song;
import com.poudelSpring.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allAlbums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, long length, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl );
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}")
    public String getOneAlbum(@PathVariable long id, Model m) {
        Album a  = albumRepository.findById(id).get();
        System.out.println(a.getSongs().size());
        m.addAttribute("album", a);
        return "oneAlbum";
    }

    @PostMapping("/albums/{id}/songs")
        public RedirectView addSongToOneAlbum(String title, String album, long length, int trackNumber ) {
            Album a = albumRepository.findByTitle(album);
            Song newSong = new Song(title, a, length, trackNumber);
            songRepository.save(newSong);
            return  new RedirectView("/albums/{id}/songs");
        }

    @GetMapping("/albums/{id}/songs")
    public String getAllSongOfOneAlbum(@PathVariable long id, Model m) {
        Album a  = albumRepository.findById(id).get();
        System.out.println(a.getSongs().size());
        m.addAttribute("album", a);
        return "oneAlbum";
    }
    }

