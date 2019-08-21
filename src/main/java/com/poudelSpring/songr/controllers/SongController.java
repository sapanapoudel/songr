package com.poudelSpring.songr.controllers;


import com.poudelSpring.songr.models.Album;
import com.poudelSpring.songr.models.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllSongs(Model m) {
//        Album theAlbum = new Album("Hot Girl Summer", "Megan Thee Stallion", 5, 4,
//                "https://upload.wikimedia.org/wikipedia/en/e/ee/Megan_Thee_Stallion_-_Hot_Girl_Summer.png");
//        Album anotherAlbum = new Album("Lover", "Taylor Swift", 3, 6,
//                "https://upload.wikimedia.org/wikipedia/en/c/cd/Taylor_Swift_-_Lover.png");
//        Album[] albums = new Album[]{theAlbum, anotherAlbum};
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allSongs";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, long length, String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl );
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }
}
