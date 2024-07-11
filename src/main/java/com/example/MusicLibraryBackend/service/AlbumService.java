package com.example.MusicLibraryBackend.service;

import com.example.MusicLibraryBackend.dto.AlbumDTO;
import com.example.MusicLibraryBackend.model.Album;
import com.example.MusicLibraryBackend.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<AlbumDTO> getAlbumsByArtist(Long artistId) {
        List<Album> albums = albumRepository.findByArtistId(artistId);
        return albums.stream()
                .map(album -> new AlbumDTO(album.getId(), album.getTitle(), album.getDescription()))
                .collect(Collectors.toList());
    }
}
