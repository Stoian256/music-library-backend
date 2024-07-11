package com.example.MusicLibraryBackend.controller;

import com.example.MusicLibraryBackend.dto.SongDTO;
import com.example.MusicLibraryBackend.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/albums/{albumId}")
    public List<SongDTO> getSongsByAlbum(@PathVariable Long albumId) {
        return songService.getSongsByAlbum(albumId);
    }
}