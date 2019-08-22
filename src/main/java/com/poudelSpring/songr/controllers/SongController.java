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

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }
}
