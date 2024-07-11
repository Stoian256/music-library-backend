package com.example.MusicLibraryBackend.controller;

import com.example.MusicLibraryBackend.dto.ArtistDTO;

import com.example.MusicLibraryBackend.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final ArtistService artistService;

    @GetMapping
    public List<ArtistDTO> search(@RequestParam String name) {
        return artistService.findByName(name);
    }
}

