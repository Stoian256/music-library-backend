package com.example.MusicLibraryBackend.service;

import com.example.MusicLibraryBackend.dto.ArtistDTO;
import com.example.MusicLibraryBackend.model.Artist;
import com.example.MusicLibraryBackend.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<ArtistDTO> findAll() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream()
                .map(artist -> new ArtistDTO(artist.getId(), artist.getName()))
                .collect(Collectors.toList());
    }

    public List<ArtistDTO> findByName(String name) {
        List<Artist> artists = artistRepository.findByNameContainingIgnoreCase(name);
        return artists.stream()
                .map(artist -> new ArtistDTO(artist.getId(), artist.getName()))
                .collect(Collectors.toList());
    }
}
